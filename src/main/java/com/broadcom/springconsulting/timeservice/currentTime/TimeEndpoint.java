package com.broadcom.springconsulting.timeservice.currentTime;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@PrimaryAdapter
@RestController
class TimeEndpoint {

    private static final Logger log = LoggerFactory.getLogger( TimeEndpoint.class );

    private final CurrentTimeUseCase useCase;

    TimeEndpoint( final CurrentTimeUseCase useCase ) {

        this.useCase = useCase;

    }

    @GetMapping( "/currentTime" )
    Map<String, Instant> currentTime() {
        log.debug( "currentTime : enter" );

        try {

            var result = this.useCase.execute( new CurrentTimeUseCase.CurrentTimeCommand());

            log.debug( "currentTime : exit" );
            return Map.of("current_time", result.value() );

        } catch( Exception e ) {
            log.error( "currentTime : error [{}]", e.getMessage(), e );

            return Map.of();
        }

    }

}
