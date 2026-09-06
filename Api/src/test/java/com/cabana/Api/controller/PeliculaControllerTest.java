package com.cabana.Api.controller;

import com.cabana.Api.model.Pelicula;
import com.cabana.Api.service.PeliculaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PeliculaService service;

    @Test
    void testListarPeliculas() throws Exception {
        Pelicula p = new Pelicula("Interstellar", "Espacio", 2014, "url");
        when(service.obtenerTodas()).thenReturn(Collections.singletonList(p));

        mockMvc.perform(get("/api/peliculas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].titulo").value("Interstellar"));
    }
}