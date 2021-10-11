package com.example.demo.web.controller;

import com.example.demo.ZoneNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TimeControllerTest {

    private TimeController sut;

    @BeforeEach
    void setUp() {
        sut = new TimeController();
    }

    @Test
    void producesTimeUTC() {
        var response = Instant.parse(sut.pedirHora().getRespuesta());

        assertThat(response).isCloseTo(Instant.now(), within(1, ChronoUnit.SECONDS));
    }

    @Test
    void producesTimeWithTimeZone() {
        var response = OffsetDateTime.parse(sut.pedirHora("America", "Mexico_City").getRespuesta());

        assertThat(response).isCloseTo(OffsetDateTime.now(ZoneId.of("America/Mexico_City")), within(1, ChronoUnit.SECONDS));
    }

    @Test
    void lanzaExcepcionCorrectaSiNoExisteLaZona() {
        ZoneNameException exception = assertThrows(ZoneNameException.class, () -> sut.pedirHora("una", "zona"));

        assertThat(exception.getMessage()).contains("No se encontró la zona con nombre [una/zona]");


    }
}