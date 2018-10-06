package com.sapient.universe.universe;

public enum EntityType {
	

	
 PLANETS("/planets"),STARSHIPS("/starhsips"),VEHICLES("/vehicles"),PEOPLE("/peoples"),FILMS("/films"),SPECIES("/species");
 
 private String url;
	
 public String getUrl() {
	return url;
}

private EntityType(String url) {
     
     this.url = url;
 }

}
