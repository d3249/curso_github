package com.example.demo.web.controller;

import com.example.demo.ZoneNameException;
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

    @GetMapping("")
    public ServerResponse<String> pedirHora() {
        return new ServerResponse<>(LocalDateTime.now(ZoneId.of("UTC"))
                .truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_DATE_TIME) + "Z");
    }

    @GetMapping("/{region}/{zona}")
    public ServerResponse<String> pedirHora(@PathVariable String region, @PathVariable String zona) {

        var zoneName = String.format("%s/%s", region, zona);

        ZoneId zoneId = null;

        try {
            zoneId = ZoneId.of(zoneName);
        } catch (ZoneRulesException e) {
            throw new ZoneNameException(String.format("No se encontró la zona con nombre [%s]", zoneName));
        }

        var content = OffsetDateTime.now(zoneId)
                .truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return new ServerResponse<>(content);
    }
}
