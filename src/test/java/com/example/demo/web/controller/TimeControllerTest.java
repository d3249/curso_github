package com.example.demo.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class TimeControllerTest {

    private TimeController sut;

    @BeforeEach
    void setUp() {
        sut = new TimeController();
    }

    @Test
    void producesTimeUTC() {
        var expected = Instant.now();

        var response = sut.pedirHora();

        assertThat(response.getRespuesta()).isCloseTo(expected, within(100, ChronoUnit.MILLIS));
    }
}