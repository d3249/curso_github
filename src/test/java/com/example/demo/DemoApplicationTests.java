package com.example.demo;

import com.example.demo.web.controller.dto.ServerResponse;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
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
import static org.hamcrest.Matchers.*;

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

        TypeRef<ServerResponse<String>> responseType = new TypeRef<>() {
        };


        var response = get("/time")
                .then()
                .assertThat()
                .statusCode(is(HttpStatus.OK.value()))
                .and()
                .extract()
                .body()
                .as(responseType);

        var responseTime = Instant.parse(response.getRespuesta());

        assertThat(responseTime).isCloseTo(Instant.now(), within(1, ChronoUnit.SECONDS));
    }


    @Test
    void truncatesTimeToSeconds() {


        var expectedPattern = "^\\d{4}(-\\d{2}){2}T\\d{2}:\\d{2}:\\d{2}Z$";

        get("/time")
                .then()
                .assertThat()
                .statusCode(is(HttpStatus.OK.value()))
                .and()
                .body("respuesta", matchesPattern(expectedPattern));

    }
}
