package com.example.demo.web.controller;

import com.example.demo.web.controller.dto.Respuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("")
    public Respuesta<Instant> pedirHora() {
        return new Respuesta<>(Instant.now());
    }
}
