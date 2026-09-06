package com.cabana.Api.controller;

import com.cabana.Api.model.Usuario;
import com.cabana.Api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.guardar(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable String id, @RequestBody Usuario usuario) {
        return service.obtenerPorId(id).map(u -> {
            usuario.setId(id);
            return ResponseEntity.ok(service.guardar(usuario));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Rutas específicas de negocio para Favoritos
    @PostMapping("/{usuarioId}/favoritos/{peliculaId}")
    public ResponseEntity<Void> agregarFavorito(@PathVariable String usuarioId, @PathVariable String peliculaId) {
        if (service.agregarFavorito(usuarioId, peliculaId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{usuarioId}/favoritos/{peliculaId}")
    public ResponseEntity<Void> eliminarFavorito(@PathVariable String usuarioId, @PathVariable String peliculaId) {
        if (service.eliminarFavorito(usuarioId, peliculaId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}