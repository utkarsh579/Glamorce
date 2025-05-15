package com.stackroute.appointmentservice.repository;

import com.stackroute.appointmentservice.dto.SlotsDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DtoRepository extends MongoRepository<SlotsDto,String> {
}
