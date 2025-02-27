package com.broadcom.springconsulting.timeservice.config.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

public class MyLoggerCustomizer implements StructuredLogFormatter<ILoggingEvent> {

    @Override
    public String format( ILoggingEvent event ) {

        return "time=" + event.getInstant() + " ...";
    }

}
