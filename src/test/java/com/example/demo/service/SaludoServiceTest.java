package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SaludoServiceTest {

    private SaludoService sut;

    @BeforeEach
    void setUp() {
        sut = new SaludoService();
    }

    @Test
    void contestaHolaMundoSinParametro() {
        String result = sut.saludar();

        assertThat(result).isEqualTo("Hola mundo");
    }

    @Test
    void contestaHolaMundoSiSeMandaNull() {
        String result = sut.saludar(null);

        assertThat(result).isEqualTo("Hola mundo");
    }

    @Test
    void contestaHolaMundoSiSeMandaStringVacio() {

        String result = sut.saludar("     ");

        assertThat(result).isEqualTo("Hola mundo");
    }

    @Test
    void siSeMandaLlamarcConUnstringRespondeHolaStr() {

        String result = sut.saludar("str");

        assertThat(result).isEqualTo("Hola Str");
    }

    @Test
    void corrigeElUsoDeMayusculasYMinusculas() {

        String result = sut.saludar("aLBeRtO");

        assertThat(result).isEqualTo("Hola Alberto");
    }

    @Test
    void tomaSoloLaPrimeraPalabra() {
        String result = sut.saludar("Alberto Bernardo");

        assertThat(result).isEqualTo("Hola Alberto");
    }
}
