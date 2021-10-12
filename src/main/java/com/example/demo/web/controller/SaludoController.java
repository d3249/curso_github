package com.example.demo.web.controller;

import com.example.demo.web.controller.dto.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import static java.lang.String.format;

@RestController
@RequestMapping("/hola")
public class SaludoController {


    @GetMapping("/{nombre}")
    public ServerResponse<String> slaudar(@PathVariable String nombre) {

        var nombreFinal = nombre;

        if (nombreFinal == null || nombreFinal.isBlank()) {
            nombreFinal = "Mundo";
        } else {

            var firstLetter = nombre.substring(0, 1);
            var rest = nombre.substring(1);

            var stringBuilder = new StringBuilder(firstLetter.toUpperCase(Locale.ROOT));

            stringBuilder.append(rest.toLowerCase(Locale.ROOT));

            nombreFinal = stringBuilder.toString();

        }


        return new ServerResponse<>(format("Hola %s", nombreFinal.trim()));
    }

}
