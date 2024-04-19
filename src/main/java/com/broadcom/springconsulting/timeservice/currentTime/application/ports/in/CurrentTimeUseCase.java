package com.broadcom.springconsulting.timeservice.currentTime.application.ports.in;

import com.broadcom.springconsulting.timeservice.currentTime.application.model.CurrentTimeModel;

public interface CurrentTimeUseCase {

    CurrentTimeModel execute( CurrentTimeCommand command ) throws Exception;

    record CurrentTimeCommand() { }

}
