package com.broadcom.springconsulting.timeservice.currentTime;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.time.Instant;
import java.util.UUID;

@SecondaryPort
interface SaveCurrentTimePort {

    UUID save( final Instant value );

}
