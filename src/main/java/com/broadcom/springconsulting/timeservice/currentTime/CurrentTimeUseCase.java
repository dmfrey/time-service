package com.broadcom.springconsulting.timeservice.currentTime;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CurrentTimeUseCase {

    CurrentTimeModel execute( CurrentTimeCommand command ) throws Exception;

    record CurrentTimeCommand() { }

}
