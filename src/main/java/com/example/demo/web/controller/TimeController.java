package com.example.demo.web.controller;

import com.example.demo.web.controller.dto.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("")
    public ServerResponse<String> pedirHora() {
        return new ServerResponse<>(LocalDateTime.now(ZoneId.of("UTC"))
                .truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_DATE_TIME) + "Z");
    }
}
