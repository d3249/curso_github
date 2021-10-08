package com.example.demo.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class ServerResponse<T> {
    private final T respuesta;

    @JsonCreator
    public ServerResponse(T respuesta) {
        this.respuesta = respuesta;
    }

    public T getRespuesta() {
        return respuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerResponse)) return false;
        ServerResponse<?> serverResponse1 = (ServerResponse<?>) o;
        return Objects.equals(getRespuesta(), serverResponse1.getRespuesta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRespuesta());
    }
}
