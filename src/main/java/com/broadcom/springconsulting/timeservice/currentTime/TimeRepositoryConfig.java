package com.broadcom.springconsulting.timeservice.currentTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@Configuration
class TimeRepositoryConfig {

    @Bean
    BeforeConvertCallback<CurrentTimeRecord> beforeConvertCallback() {

        return (time) -> {
            if (time.id == null) {
                time.id = UUID.randomUUID();
            }
            return time;
        };

    }

}
