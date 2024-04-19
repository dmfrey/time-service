package com.broadcom.springconsulting.timeservice.currentTime.adapters.out.persistence;

import com.broadcom.springconsulting.timeservice.currentTime.application.ports.out.SaveCurrentTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Component
class CurrentTimePersistenceAdapter implements SaveCurrentTime {

    private static final Logger log = LoggerFactory.getLogger( CurrentTimePersistenceAdapter.class );

    final CurrentTimeRepository repository;

    CurrentTimePersistenceAdapter( final CurrentTimeRepository repository ) {

        this.repository = repository;

    }

    @Override
    public UUID save( Instant value ) {
        log.debug( "save : enter" );

        var empty = new CurrentTimeRecord();
        empty.setValue( Timestamp.from( value ) );

        var created = this.repository.save( empty );
        log.info( "save : created new entry [{}]", created );

        log.debug( "save : exit" );
        return created.getId();
    }

}
