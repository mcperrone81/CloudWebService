FROM openjdk:11
EXPOSE 5051
ADD target/articoli-webservice.jar articoli-webservice.jar
ENTRYPOINT ["java","-jar","/articoli-webservice.jar"]