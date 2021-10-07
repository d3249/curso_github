package com.example.demo.web.controller;

import com.example.demo.web.controller.dto.Respuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/hola")
public class SaludoController {


    @GetMapping("/{nombre}")
    public Respuesta<String> slaudar(@PathVariable String nombre) {

        var nombreFinal = nombre;

        if (nombre == null || nombre.isBlank())
            nombreFinal = "Mundo";


        return new Respuesta<>(format("Hola %s", nombreFinal.trim()));
    }

}
