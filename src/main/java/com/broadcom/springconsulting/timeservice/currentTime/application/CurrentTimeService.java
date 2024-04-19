package com.broadcom.springconsulting.timeservice.currentTime.application;

import com.broadcom.springconsulting.timeservice.currentTime.application.model.CurrentTimeModel;
import com.broadcom.springconsulting.timeservice.currentTime.application.ports.in.CurrentTimeUseCase;
import com.broadcom.springconsulting.timeservice.currentTime.application.ports.out.SaveCurrentTime;
import com.broadcom.springconsulting.timeservice.currentTime.application.services.CurrentTimeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class CurrentTimeService implements CurrentTimeUseCase {

    private static final Logger log = LoggerFactory.getLogger( CurrentTimeService.class );

    private final CurrentTimeGenerator generator;
    private final SaveCurrentTime saveCurrentTimePort;

    CurrentTimeService( final CurrentTimeGenerator generator, final SaveCurrentTime saveCurrentTimePort ) {

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
