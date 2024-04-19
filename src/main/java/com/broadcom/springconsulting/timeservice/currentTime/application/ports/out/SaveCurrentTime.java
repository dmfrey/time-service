package com.broadcom.springconsulting.timeservice.currentTime.application.ports.out;

import java.time.Instant;
import java.util.UUID;

public interface SaveCurrentTime {

    UUID save(final Instant value );

}
