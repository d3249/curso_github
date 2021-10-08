package com.example.demo.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class Respuesta<T> {
    private final T respuesta;

    @JsonCreator
    public Respuesta(T respuesta) {
        this.respuesta = respuesta;
    }

    public T getRespuesta() {
        return respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Respuesta)) return false;
        Respuesta<?> respuesta1 = (Respuesta<?>) o;
        return Objects.equals(getRespuesta(), respuesta1.getRespuesta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRespuesta());
    }
}
