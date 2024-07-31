package com.broadcom.springconsulting.timeservice;

import com.tngtech.archunit.core.domain.JavaClass;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {

    ApplicationModules modules = ApplicationModules.of( Application.class, JavaClass.Predicates.resideInAPackage( "com.broadcom.springconsulting.timeservice.config" ) );

    @Test
    void verifiesModuleStructure() {

        modules
                .verify()
                .forEach( System.out::println );

    }

    @Test
    void createModuleDocumentation() {
        new Documenter( modules ).writeDocumentation();
    }

    @Test
    void createPlantUml() {
        new Documenter( modules )
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

    @Test
    void writeDocumentationSnippets() {

        new Documenter( modules )
                .writeModuleCanvases();
    }

}
