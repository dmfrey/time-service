package com.broadcom.springconsulting.timeservice.currentTime;

import org.springframework.data.repository.CrudRepository;

interface CurrentTimeRepository extends CrudRepository<CurrentTimeRecord, String> { }
