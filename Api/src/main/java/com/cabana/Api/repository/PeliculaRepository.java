package com.cabana.Api.repository;
import com.cabana.Api.model.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PeliculaRepository {
    private final List<Pelicula> dbPeliculas = new ArrayList<>();

    public List<Pelicula> findAll() {
        return dbPeliculas;
    }

    public Optional<Pelicula> findById(String id) {
        return dbPeliculas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Pelicula save(Pelicula pelicula) {
        if (pelicula.getId() == null) {
            pelicula.setId(UUID.randomUUID().toString());
        } else {
            dbPeliculas.removeIf(p -> p.getId().equals(pelicula.getId()));
        }
        dbPeliculas.add(pelicula);
        return pelicula;
    }

    public boolean deleteById(String id) {
        return dbPeliculas.removeIf(p -> p.getId().equals(id));
    }
}