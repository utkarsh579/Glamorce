package com.stackroute.appointmentservice.service;

import com.stackroute.appointmentservice.model.BookedAppointment;

import com.stackroute.appointmentservice.repository.AppointmentBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.stackroute.appointmentservice.model.Slots.SEQUENCE_NAME;

@Service
public class AppointmentBookingServiceImpl implements AppointmentBookingService{
    @Autowired
    private AppointmentBookingRepository appointmentBookingRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Override
    public BookedAppointment toBookAppointment(BookedAppointment bookedAppointment){

        BookedAppointment appointment = appointmentBookingRepository.findByUserId(bookedAppointment.getUserId());
      if (appointment == null){
          System.out.println("hello");
          String c="BAID";
          String id= String.valueOf(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));

          bookedAppointment.setBookedAppointmentId(c+id);
         return appointmentBookingRepository.insert(bookedAppointment);
      }
      else {
          System.out.println("test");
          appointment.getServiceDetailsList().addAll(bookedAppointment.getServiceDetailsList());
          return appointmentBookingRepository.save(appointment);
      }


    }

    @Override
    public BookedAppointment getBookedDetails(String userId) {
        return appointmentBookingRepository.findByUserId(userId);
    }


}
