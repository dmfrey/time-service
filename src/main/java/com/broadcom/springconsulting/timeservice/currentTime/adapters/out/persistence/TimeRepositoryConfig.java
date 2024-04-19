package com.broadcom.springconsulting.timeservice.currentTime.adapters.out.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

    @Configuration
    @EnableAutoConfiguration
    @Profile({ "local" })
    static class LocalConfiguration {

        @Bean( name = "dataSource" )
        public DriverManagerDataSource getDataSource() {

            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName( "org.h2.Driver" );
            driverManagerDataSource.setUrl( "jdbc:h2:mem:test;IGNORECASE=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE" );

            return driverManagerDataSource;
        }

    }

}
