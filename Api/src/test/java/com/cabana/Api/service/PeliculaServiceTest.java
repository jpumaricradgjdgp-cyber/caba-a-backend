package com.cabana.Api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cabana.Api.model.Pelicula;
import com.cabana.Api.repository.PeliculaRepository;

public class PeliculaServiceTest {

    @Mock
    private PeliculaRepository repository;

    @InjectMocks
    private PeliculaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodas() {
        Pelicula p1 = new Pelicula("Matrix", "Ciencia ficción", 1999, "url");
        Pelicula p2 = new Pelicula("Shrek", "Animación", 2001, "url");
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Pelicula> resultado = service.obtenerTodas();

        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGuardarPelicula() {
        Pelicula nueva = new Pelicula("Inception", "Sueños", 2010, "url");
        when(repository.save(any(Pelicula.class))).thenReturn(nueva);

        Pelicula resultado = service.guardar(nueva);

        assertNotNull(resultado.getId());
        assertEquals("Inception", resultado.getTitulo());
    }
}