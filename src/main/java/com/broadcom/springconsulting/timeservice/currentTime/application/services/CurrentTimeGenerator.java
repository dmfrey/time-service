package com.broadcom.springconsulting.timeservice.currentTime.application.services;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CurrentTimeGenerator {

    public Instant calculate() {

        return Instant.now();
    }

}
