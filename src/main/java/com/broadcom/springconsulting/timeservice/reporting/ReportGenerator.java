package com.broadcom.springconsulting.timeservice.reporting;

import com.broadcom.springconsulting.timeservice.services.CurrentTimeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ReportGenerator {

    private static final Logger log = LoggerFactory.getLogger( ReportGenerator.class );

    private final CurrentTimeGenerator generator;

    public ReportGenerator( final CurrentTimeGenerator generator ) {

        this.generator = generator;

    }

    void showCurrentTime() {

        log.info( "The current time is [{}]", this.generator.calculate() );

    }

}
