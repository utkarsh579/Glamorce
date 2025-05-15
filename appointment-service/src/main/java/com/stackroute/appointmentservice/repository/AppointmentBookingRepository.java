package com.stackroute.appointmentservice.repository;

import com.stackroute.appointmentservice.model.BookedAppointment;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface AppointmentBookingRepository extends MongoRepository<BookedAppointment,String> {

  BookedAppointment findByUserId(String userId);
}

