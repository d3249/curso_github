package com.example.demo.web;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SaludoControllerTest {

    private SaludoController sut = new SaludoController();

    @Test
    void adjuntaNombre() {
        var respuesta = sut.slaudar("Edgar");

        assertThat(respuesta).isEqualTo("Hola Edgar");
    }

    @Test
    void siSeMandaCadenaVaciaReemplazaConMundo() {

        var respuesta = sut.slaudar("");

        assertThat(respuesta).isEqualTo("Hola Mundo");
    }

    @Test
    void siSeMandaNullSeReemplazaConMundo() {
        var respuesta = sut.slaudar(null);

        assertThat(respuesta).isEqualTo("Hola Mundo");
    }

    @Test
    void seEliminanEspaciosAlRededor() {

        var respuesta = sut.slaudar("  Edgar  ");

        assertThat(respuesta).isEqualTo("Hola Edgar");
    }
}