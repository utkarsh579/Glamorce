package com.stackroute.appointmentservice.service;
import com.stackroute.appointmentservice.model.BookedAppointment;




public interface AppointmentBookingService {




    BookedAppointment toBookAppointment(BookedAppointment bookedAppointment);

    BookedAppointment getBookedDetails(String userId);
}
