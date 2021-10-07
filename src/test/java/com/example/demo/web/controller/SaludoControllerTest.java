package com.example.demo.web.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SaludoControllerTest {

    private SaludoController sut = new SaludoController();

    @Test
    void adjuntaNombre() {
        var respuesta = sut.slaudar("Edgar");

        Assertions.assertThat(respuesta.getRespuesta()).isEqualTo("Hola Edgar");
    }

    @Test
    void siSeMandaCadenaVaciaReemplazaConMundo() {

        var respuesta = sut.slaudar("");

        Assertions.assertThat(respuesta.getRespuesta()).isEqualTo("Hola Mundo");
    }

    @Test
    void siSeMandaNullSeReemplazaConMundo() {
        var respuesta = sut.slaudar(null);

        Assertions.assertThat(respuesta.getRespuesta()).isEqualTo("Hola Mundo");
    }

    @Test
    void seEliminanEspaciosAlRededor() {

        var respuesta = sut.slaudar("  Edgar  ");

        Assertions.assertThat(respuesta.getRespuesta()).isEqualTo("Hola Edgar");
    }
}