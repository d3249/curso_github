package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class SaludoService {
    private static final String DEFAULT = "Hola mundo";

    public String saludar() {
        return DEFAULT;
    }

    public String saludar(String nombre) {

        if (nombre == null || nombre.isBlank())
            return DEFAULT;

        final String primerNombre = nombre.split("\\s+")[0];

        var primeraLetra = primerNombre.substring(0, 1).toUpperCase(Locale.ROOT);
        var resto = primerNombre.substring(1).toLowerCase(Locale.ROOT);

        return String.format("Hola %s%s", primeraLetra, resto);
    }
}
