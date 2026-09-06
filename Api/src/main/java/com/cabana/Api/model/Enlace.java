package com.cabana.Api.model;
import java.util.UUID;

public class Enlace {
    private String id;
    private String servidor; 
    private String url;
    private String idioma;   
    private String calidad;  

    public Enlace() {
        this.id = UUID.randomUUID().toString();
    }

    public Enlace(String servidor, String url, String idioma, String calidad) {
        this.id = UUID.randomUUID().toString();
        this.servidor = servidor;
        this.url = url;
        this.idioma = idioma;
        this.calidad = calidad;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getServidor() { return servidor; }
    public void setServidor(String servidor) { this.servidor = servidor; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public String getCalidad() { return calidad; }
    public void setCalidad(String calidad) { this.calidad = calidad; }
}