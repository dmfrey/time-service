package com.broadcom.springconsulting.timeservice.currentTime;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@SecondaryAdapter
@Repository
class CurrentTimePersistenceAdapter implements SaveCurrentTimePort {

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
