package com.perrone.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.perrone.demo.entities.Articoli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articoli")
public class TestController
{
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private List<Articoli> initData()
	{
		List<Articoli> articoli = new ArrayList<Articoli>();
		
		articoli.add(new Articoli("014600301","BARILLA FARINA 1 KG","PZ",24,1.0,1.09));
		articoli.add(new Articoli("013500121","BARILLA PASTA GR.500 N.70 1/2 PENNE","PZ",30,0.500,1.30));
		articoli.add(new Articoli("007686402","FINDUS FIOR DI NASELLO 300 GR","PZ",8,0.300,6.46));
		articoli.add(new Articoli("057549001","FINDUS CROCCOLE 400 GR","PZ",12,0.400,5.97));
		articoli.add(new Articoli("002000301","ACQUA ULIVETO 15 LT","PZ",6,1.5,0.87));
		articoli.add(new Articoli("002000344","ACQUA SAN GEMINI 15 LT","PZ",6,1.5,0.87));
		articoli.add(new Articoli("014670789","DE CECCO SPAGHETTI PASTA 1 KG","PZ",24,1.0,1.09));
		articoli.add(new Articoli("014604116","DE CECCO BUCATINI GR.500","PZ",24,1.0,1.09));

		return articoli;
	}

	@GetMapping(value = "/cerca/codice/{codart}", produces = "application/json")
	public ResponseEntity<Articoli> listArtByCodArt(@PathVariable("codart") String CodArt) 
	{
		logger.info("****** Otteniamo l'articolo con codice " + CodArt + " *******");

	
		List<Articoli> articolo = this.initData()
			.stream()
			.filter(u -> u.getCodArt().equals(CodArt))
			.collect(Collectors.toList());

		
		return new ResponseEntity<Articoli>(articolo.get(0), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/cerca/descrizione/{filter}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Articoli>> listArtByDesc(@PathVariable("filter") String Filter)
	{
		logger.info("****** Otteniamo l'articolo con descrizione " + Filter + " *******");

		List<Articoli> articoli = this.initData()
			.stream()
			.filter(u -> u.getDescrizione().toUpperCase().contains(Filter.toUpperCase()))
			.collect(Collectors.toList());

		return new ResponseEntity<List<Articoli>>(articoli, HttpStatus.OK);
		
	}
}
