package com.broadcom.springconsulting.timeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@RestController
class TimeEndpoint {

	@GetMapping( "/currentTime" )
	Map<String, Instant> currentTime( final TimeService timeService ) {

		Instant currentTime = timeService.calculate();

		return Map.of("current_time", currentTime );
	}

}

@Component
class TimeService {

	Instant calculate() {

		return Instant.now();
	}

}
