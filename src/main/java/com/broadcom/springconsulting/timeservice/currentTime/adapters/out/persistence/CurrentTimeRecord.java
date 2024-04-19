package com.broadcom.springconsulting.timeservice.currentTime.adapters.out.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Table( "time_log" )
class CurrentTimeRecord {

    @Id
    @Column( "id" )
    UUID id;

    @Column( "time" )
    Timestamp value;

    public CurrentTimeRecord() { }

    UUID getId() {

        return id;
    }

    void setId( UUID id ) {

        this.id = id;

    }

    Timestamp getValue() {

        return value;
    }

    public void setValue( Timestamp value ) {

        this.value = value;

    }

    @Override
    public boolean equals( Object o ) {

        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;

        CurrentTimeRecord that = (CurrentTimeRecord) o;

        return Objects.equals( id, that.id ) && Objects.equals( value, that.value );
    }

    @Override
    public int hashCode() {

        return Objects.hash( id, value );
    }

    @Override
    public String toString() {
        return "CurrentTimeRecord{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }

}
