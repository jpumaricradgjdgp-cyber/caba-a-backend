package com.cabana.Api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private String id;
    private String username;
    private String email;
    private String password;
    private String idiomaPreferido;
    private List<String> peliculasFavoritas; 

    public Usuario() {
        this.id = UUID.randomUUID().toString();
        this.peliculasFavoritas = new ArrayList<>();
    }

    public Usuario(String username, String email, String password, String idiomaPreferido) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.password = password;
        this.idiomaPreferido = idiomaPreferido;
        this.peliculasFavoritas = new ArrayList<>();
    }

    public void agregarFavorito(String idPelicula) {
        if (!this.peliculasFavoritas.contains(idPelicula)) {
            this.peliculasFavoritas.add(idPelicula);
        }
    }

    public void eliminarFavorito(String idPelicula) {
        this.peliculasFavoritas.remove(idPelicula);
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getIdiomaPreferido() { return idiomaPreferido; }
    public void setIdiomaPreferido(String idiomaPreferido) { this.idiomaPreferido = idiomaPreferido; }
    public List<String> getPeliculasFavoritas() { return peliculasFavoritas; }
    public void setPeliculasFavoritas(List<String> peliculasFavoritas) { this.peliculasFavoritas = peliculasFavoritas; }
}