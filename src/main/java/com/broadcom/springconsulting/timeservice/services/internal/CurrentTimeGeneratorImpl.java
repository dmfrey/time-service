package com.broadcom.springconsulting.timeservice.services.internal;

import com.broadcom.springconsulting.timeservice.services.CurrentTimeGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
class CurrentTimeGeneratorImpl implements CurrentTimeGenerator {

    @Override
    public Instant calculate() {

        return Instant.now();
    }

}
