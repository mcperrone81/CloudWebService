package com.perrone.demo.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Articoli implements Serializable
{
	private static final long serialVersionUID = 7361753083273455478L;
	
	private String codArt;
	private String descrizione;	
	private String um;
	private String codStat;
	private Integer pzCart;
	private double pesoNetto;
	private String idStatoArt;
	private Date dataCreaz;
	private double prezzo;

	public Articoli(String CodArt, String Descrizione, String Um, Integer PzCart, double PesoNetto, double Prezzo)
	{
		this.codArt = CodArt;
		this.descrizione = Descrizione;
		this.um = Um;
		this.pzCart = PzCart;
		this.pesoNetto = PesoNetto;
		this.prezzo = Prezzo; 
	}
	
}
