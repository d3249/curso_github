package com.example.demo.web.controller;

import com.example.demo.ZoneNameException;
import com.example.demo.service.TiempoService;
import com.example.demo.web.controller.dto.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRulesException;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TiempoService service;

    public TimeController(TiempoService service) {
        this.service = service;
    }

    @GetMapping("")
    public ServerResponse<OffsetDateTime> pedirHora() {
        return new ServerResponse<>(service.time());
    }

    @GetMapping("/{region}/{zona}")
    public ServerResponse<OffsetDateTime> pedirHora(@PathVariable String region, @PathVariable String zona) {

        var zoneName = String.format("%s/%s", region, zona);

        return new ServerResponse<>(service.time(zoneName));
    }
}
