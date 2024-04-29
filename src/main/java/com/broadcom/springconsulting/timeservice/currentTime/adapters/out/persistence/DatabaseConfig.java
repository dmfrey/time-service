package com.broadcom.springconsulting.timeservice.currentTime.adapters.out.persistence;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints( DatabaseConfig.LiquibaseRuntimeHints.class )
public class DatabaseConfig {

    static class LiquibaseRuntimeHints implements RuntimeHintsRegistrar {


        @Override
        public void registerHints( RuntimeHints hints, ClassLoader classLoader ) {

            hints.resources().registerPattern("db/changelog/*" );

        }

    }

}
