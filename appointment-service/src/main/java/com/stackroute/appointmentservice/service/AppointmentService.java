package com.stackroute.appointmentservice.service;

import com.stackroute.appointmentservice.exceptions.AppointmentIdNotFound;
import com.stackroute.appointmentservice.exceptions.EmployeeIdNotFound;
import com.stackroute.appointmentservice.exceptions.ServiceNotFound;

import com.stackroute.appointmentservice.model.Slots;


import java.text.ParseException;
import java.util.List;

public interface AppointmentService {
    Slots createAppointment(Slots appointment) throws ParseException;
    String deleteAppointment(String appointmentId) throws AppointmentIdNotFound;

    String deleteAppointment(int appointmentId) throws AppointmentIdNotFound;

    String updateAppointment(Slots appointment) throws AppointmentIdNotFound;

    List<Slots> getAllAppointments();
    List<Slots> getAppointmentsByServiceId(String serviceId) throws ServiceNotFound;
    List<Slots> getByServiceIdAndDate(String serviceId, String date) throws ServiceNotFound;

    List<Slots> getAppointmentsByEmployeeId(String employeeId);

    List<Slots> getAppointmentsByEmployeeAndDate(String employeeId, String date) throws EmployeeIdNotFound;
}
