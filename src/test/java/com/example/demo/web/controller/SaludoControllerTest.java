package com.example.demo.web.controller;

import com.example.demo.service.SaludoService;
import com.example.demo.web.controller.dto.ServerResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

class SaludoControllerTest {


    @Mock
    private SaludoService service;

    @InjectMocks
    private SaludoController sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void respondeConServerResponseString() {

        given(service.saludar(anyString())).willAnswer(context -> context.getArgument(0));

        var respuesta = sut.slaudar("Edgar");

        Assertions.assertThat(respuesta).isInstanceOf(ServerResponse.class);

    }

}