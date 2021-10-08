package com.example.demo;

import com.example.demo.web.controller.dto.Respuesta;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void saludo() {
        get("/hola/Juan")
                .then()
                .assertThat()
                .statusCode(is(HttpStatus.OK.value()))
                .and()
                .body("respuesta", is(equalTo("Hola Juan")));
    }

    @Test
    void time() {

        TypeRef<Respuesta<Instant>> responseType = new TypeRef<>() {
        };

        var expected = Instant.now();

        var response = get("/time")
                .then()
                .assertThat()
                .statusCode(is(HttpStatus.OK.value()))
                .and()
                .extract()
                .body()
                .as(responseType);

        assertThat(response.getRespuesta()).isCloseTo(expected, within(100, ChronoUnit.MILLIS));
    }

}
