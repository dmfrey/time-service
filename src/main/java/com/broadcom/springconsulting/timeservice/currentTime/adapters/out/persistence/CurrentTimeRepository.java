package com.broadcom.springconsulting.timeservice.currentTime.adapters.out.persistence;

import org.springframework.data.repository.CrudRepository;

interface CurrentTimeRepository extends CrudRepository<CurrentTimeRecord, String> { }
