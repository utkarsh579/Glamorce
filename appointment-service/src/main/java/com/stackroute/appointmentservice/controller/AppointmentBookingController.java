package com.stackroute.appointmentservice.controller;

import com.stackroute.appointmentservice.model.BookedAppointment;
import com.stackroute.appointmentservice.service.AppointmentBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("bookappointment")
//@CrossOrigin(origins = "*")
public class AppointmentBookingController {
    @Autowired
    private AppointmentBookingService appointmentBookingService;

//    @Autowired
//    private SequenceGeneratorService sequenceGeneratorService;
//    @Autowired
//    private BookedAppointment bookedAppointment;
    //private String Seq=bookedAppointment.
//    private String c="GLA";
//    private int id= (sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
    @PostMapping("/appointment")
    public ResponseEntity<?> toBookAppointment(@RequestBody BookedAppointment bookedAppointment){
        //bookedAppointment.setServiceDetailsList(new ArrayList<SlotDetails>());
//        sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME);
//        bookedAppointment.setBookedAppointmentId(c+id);
        return new ResponseEntity<>(appointmentBookingService.toBookAppointment(bookedAppointment), HttpStatus.OK);
    }
    @GetMapping("/appointment-details/{emailId}")
    public ResponseEntity<?> getBookAppointmentDetails(@PathVariable String emailId){
        return new ResponseEntity<>(appointmentBookingService.getBookedDetails(emailId),HttpStatus.OK);
    }
}
