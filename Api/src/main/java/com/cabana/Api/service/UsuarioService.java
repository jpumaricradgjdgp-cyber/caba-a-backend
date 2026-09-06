package com.cabana.Api.service;

import com.cabana.Api.model.Usuario;
import com.cabana.Api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public boolean eliminar(String id) {
        return repository.deleteById(id);
    }

    // Lógica específica del negocio para manejar favoritos
    public boolean agregarFavorito(String usuarioId, String peliculaId) {
        Optional<Usuario> usuarioOpt = repository.findById(usuarioId);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.agregarFavorito(peliculaId);
            repository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean eliminarFavorito(String usuarioId, String peliculaId) {
        Optional<Usuario> usuarioOpt = repository.findById(usuarioId);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.eliminarFavorito(peliculaId);
            repository.save(usuario);
            return true;
        }
        return false;
    }
}