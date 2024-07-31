package com.broadcom.springconsulting.timeservice.services;

import java.time.Instant;

public interface CurrentTimeGenerator {

    Instant calculate();

}
