package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {

    @Test
    void saludo() {
        get("/hola/Juan")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("respuesta", is(equalTo("Hola Juan")));

    }

}
