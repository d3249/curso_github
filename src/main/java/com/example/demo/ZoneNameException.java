package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ZoneNameException extends ResponseStatusException {

    public ZoneNameException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
