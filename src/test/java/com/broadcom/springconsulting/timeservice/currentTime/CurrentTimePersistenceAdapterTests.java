package com.broadcom.springconsulting.timeservice.currentTime;

import com.broadcom.springconsulting.timeservice.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Import( TestcontainersConfiguration.class )
@SpringBootTest
public class CurrentTimePersistenceAdapterTests {

    @Autowired
    CurrentTimePersistenceAdapter subject;

    @MockBean
    BeforeConvertCallback<CurrentTimeRecord> mockBeforeConvertCallback;

//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>( "postgres:15-alpine" )
//            .withUsername( "user" )
//            .withPassword( "password" )
//            .withDatabaseName( "public" );

//    @BeforeAll
//    static void start() {
//
//        postgres.start();
//
//    }

//    @AfterAll
//    static void end() {
//
//        postgres.stop();
//
//    }

//    @DynamicPropertySource
//    static void postgresqlProperties( DynamicPropertyRegistry registry ) {
//        registry.add( "spring.datasource.url", postgres::getJdbcUrl );
//        registry.add( "spring.datasource.username", postgres::getUsername );
//        registry.add( "spring.datasource.password", postgres::getPassword );
//    }

    @Test
    @DisplayName( "Test save current time and return UUID" )
    public void test_save(){

        var expected = UUID.fromString( "e5624273-4bfa-4b71-9c3f-c8256eae0f30" );

        var fakeTime = Instant.parse( "2024-04-18T16:47:45.00Z" );
        var fakeTimeRecordBefore = new CurrentTimeRecord();
        fakeTimeRecordBefore.setValue( Timestamp.from( fakeTime ) );

        var fakeTimeRecordAfter = new CurrentTimeRecord();
        fakeTimeRecordAfter.setId( expected );
        fakeTimeRecordAfter.setValue( Timestamp.from( fakeTime ) );

        when( mockBeforeConvertCallback.onBeforeConvert( fakeTimeRecordBefore ) ).thenReturn( fakeTimeRecordAfter );

        var actual = this.subject.save( fakeTime );

        assertThat( actual ).isEqualTo( expected );

    }

}
