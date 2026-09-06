package com.cabana.Api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pelicula {
    private String id;
    private String titulo;
    private String sinopsis;
    private int anioEstreno;
    private String urlPortada;
    private List<String> generos;
    private List<Enlace> enlaces;

    public Pelicula() {
        this.id = UUID.randomUUID().toString();
        this.generos = new ArrayList<>();
        this.enlaces = new ArrayList<>();
    }

    public Pelicula(String titulo, String sinopsis, int anioEstreno, String urlPortada) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.anioEstreno = anioEstreno;
        this.urlPortada = urlPortada;
        this.generos = new ArrayList<>();
        this.enlaces = new ArrayList<>();
    }

    public void agregarGenero(String genero) { this.generos.add(genero); }
    public void agregarEnlace(Enlace enlace) { this.enlaces.add(enlace); }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public int getAnioEstreno() { return anioEstreno; }
    public void setAnioEstreno(int anioEstreno) { this.anioEstreno = anioEstreno; }
    public String getUrlPortada() { return urlPortada; }
    public void setUrlPortada(String urlPortada) { this.urlPortada = urlPortada; }
    public List<String> getGeneros() { return generos; }
    public void setGeneros(List<String> generos) { this.generos = generos; }
    public List<Enlace> getEnlaces() { return enlaces; }
    public void setEnlaces(List<Enlace> enlaces) { this.enlaces = enlaces; }
}