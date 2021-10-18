package com.example.demo.web.controller;

import com.example.demo.service.SaludoService;
import com.example.demo.web.controller.dto.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class SaludoController {

    private final SaludoService service;

    public SaludoController(SaludoService service) {
        this.service = service;
    }

    @GetMapping("/{nombre}")
    public ServerResponse<String> slaudar(@PathVariable String nombre) {

        return new ServerResponse<>(service.saludar(nombre));
    }

}
