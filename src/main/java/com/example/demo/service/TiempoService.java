package com.example.demo.service;

import com.example.demo.exception.ZonaNoExistenteException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRulesException;

@Service
public class TiempoService {
    public OffsetDateTime time() {
        return time("UTC");
    }

    public OffsetDateTime time(String zona) {
        try {
            return OffsetDateTime.now(ZoneId.of(zona)).truncatedTo(ChronoUnit.SECONDS);
        } catch (ZoneRulesException e) {
            throw new ZonaNoExistenteException(String.format("No se encontró la zona [%s]", zona));
        }
    }
}
