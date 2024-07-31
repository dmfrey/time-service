package com.broadcom.springconsulting.timeservice.currentTime;

import liquibase.changelog.ChangeLogHistoryServiceFactory;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.Collections;

@Configuration
@ImportRuntimeHints( DatabaseConfig.LiquibaseRuntimeHints.class )
public class DatabaseConfig {

    static class LiquibaseRuntimeHints implements RuntimeHintsRegistrar {


        @Override
        public void registerHints( RuntimeHints hints, ClassLoader classLoader ) {

            hints.reflection().registerType( ChangeLogHistoryServiceFactory.class, (type) ->
                    type.withConstructor( Collections.emptyList(), ExecutableMode.INVOKE ) );

            hints.resources().registerPattern("db/changelog/*" );

        }

    }

}
