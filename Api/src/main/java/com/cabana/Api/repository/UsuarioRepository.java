package com.cabana.Api.repository;

import com.cabana.Api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UsuarioRepository {
    private final List<com.cabana.Api.model.Usuario> dbUsuarios = new ArrayList<>();

    public List<Usuario> findAll() {
        return dbUsuarios;
    }

    public Optional<Usuario> findById(String id) {
        return dbUsuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(UUID.randomUUID().toString());
        } else {
            dbUsuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
        dbUsuarios.add(usuario);
        return usuario;
    }

    public boolean deleteById(String id) {
        return dbUsuarios.removeIf(u -> u.getId().equals(id));
    }
}