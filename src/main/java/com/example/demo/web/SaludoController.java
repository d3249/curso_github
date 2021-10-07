package com.example.demo.web;

import static java.lang.String.format;

public class SaludoController {


    public String slaudar(String nombre) {

        var nombreFinal = nombre;

        if (nombre == null || nombre.isBlank())
            nombreFinal = "Mundo";


        return format("Hola %s", nombreFinal.trim());
    }

}
