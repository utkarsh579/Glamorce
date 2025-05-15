package com.stackroute.appointmentservice.repository;

import com.stackroute.appointmentservice.model.Slots;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
public interface AppointmentRepository extends MongoRepository<Slots,Integer> {
    @Query("{'serviceId':{$in:[?0]}}")
    List<Slots> getAppointmentsByServiceId(String serviceId);
    @Query("{'employeeId':{$in:[?0]}}")
    List<Slots> getAppointmentsByEmployeeId(String employeeId);
    Slots deleteByAppointmentId (int id);
//    @Query("{'appointmentId':{$in:[?0]}}")
//    boolean getByAppointmentId (int appointmentId);
}