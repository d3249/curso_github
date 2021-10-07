package com.example.demo.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Respuesta<T> {
    private final T respuesta;

    @JsonCreator
    public Respuesta(T respuesta) {
        this.respuesta = respuesta;
    }

    public T getRespuesta() {
        return respuesta;
    }
}
