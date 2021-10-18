package com.example.demo.web.controller;

import com.example.demo.service.TiempoService;
import com.example.demo.web.controller.dto.ServerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class TimeControllerTest {

    @Mock
    private TiempoService service;

    @InjectMocks
    private TimeController sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void formaCorrectamenteLaZona() {

        given(service.time("zona/region")).willReturn(OffsetDateTime.now());

        sut.pedirHora("zona", "region");

        verify(service).time("zona/region");
    }

    @Test
    void respondeConServerResponse() {

        given(service.time("zona/region")).willReturn(OffsetDateTime.now());

        var result = sut.pedirHora("zona", "region");

        assertThat(result).isInstanceOf(ServerResponse.class);

    }
}