package com.broadcom.springconsulting.timeservice.currentTime;

import com.broadcom.springconsulting.timeservice.services.CurrentTimeGenerator;
import org.jmolecules.architecture.hexagonal.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Application
@Service
class CurrentTimeService implements CurrentTimeUseCase {

    private static final Logger log = LoggerFactory.getLogger( CurrentTimeService.class );

    private final CurrentTimeGenerator generator;
    private final SaveCurrentTimePort saveCurrentTimePort;

    CurrentTimeService( final CurrentTimeGenerator generator, final SaveCurrentTimePort saveCurrentTimePort ) {

        this.generator = generator;
        this.saveCurrentTimePort = saveCurrentTimePort;

    }

    @Override
    public CurrentTimeModel execute( final CurrentTimeCommand command ) throws Exception {
        log.debug( "execute : enter" );

        var currentTime = this.generator.calculate();
        log.debug( "execute : generated new time [{}]", currentTime );

        var created = this.saveCurrentTimePort.save( currentTime );
        if( null != created ) {
            log.debug( "execute : created new entry [{}]", created );

            log.debug( "execute : exit" );
            return new CurrentTimeModel( currentTime );
        }

        log.debug( "execute : error" );
        throw new Exception( "An error occurred saving the current time to the database" );
    }

}
