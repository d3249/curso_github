package com.example.demo.service;

import com.example.demo.exception.ZonaNoExistenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xmlunit.diff.Difference;

import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TiempoServiceTest {
    private static final ZoneId UTC = ZoneId.of("UTC");

    private TiempoService sut;

    @BeforeEach
    void setUp() {
        sut = new TiempoService();
    }

    @Test
    void sinArgumentosDaElTiempoEnUTC() {
        var result = sut.time();

        assertThat(result.getOffset()).isEqualByComparingTo(ZoneOffset.UTC);

    }

    @Test
    void conUnaZonaRegresaElTiempoCorrespondiente() {

        var result = sut.time("America/Mexico_City");

        assertThat(result.getOffset()).satisfiesAnyOf(
                (ZoneOffset v) -> assertThat(v).isEqualTo(ZoneOffset.of("-06:00")),
                (ZoneOffset v) -> assertThat(v).isEqualTo(ZoneOffset.of("-05:00"))
        );
    }

    @Test
    void lanzaExcepcionCorrectaSiNoExisteZona() {

        assertThatThrownBy(() -> sut.time("no/existe"))
                .isInstanceOf(ZonaNoExistenteException.class)
                .hasMessage("No se encontró la zona [no/existe]");
    }

    @Test
    void truncaASegundosParaNoUTC() {

        var result = sut.time("Asia/Tokyo");

        var tiempoHastaSegundos = result.truncatedTo(ChronoUnit.SECONDS);

        assertThat(Duration.between(result, tiempoHastaSegundos).toNanos()).isZero();
    }

    @Test
    void truncaASegundosParaUTC() {

        var result = sut.time();

        var tiempoHastaSegundos = result.truncatedTo(ChronoUnit.SECONDS);

        assertThat(Duration.between(result, tiempoHastaSegundos).toNanos()).isZero();
    }
}
