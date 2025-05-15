package com.stackroute.appointmentservice.controller;

import com.stackroute.appointmentservice.dto.SlotsDto;
import com.stackroute.appointmentservice.exceptions.AppointmentIdNotFound;
import com.stackroute.appointmentservice.exceptions.EmployeeIdNotFound;
import com.stackroute.appointmentservice.exceptions.ServiceNotFound;
import com.stackroute.appointmentservice.model.Slots;
import com.stackroute.appointmentservice.service.AppointmentService;
import com.stackroute.appointmentservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static com.stackroute.appointmentservice.model.Slots.SEQUENCE_NAME;

@RestController
@RequestMapping("/appointment")
//@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/create-appointment")
    public ResponseEntity<?> createAppointment(@Valid @RequestBody SlotsDto slots) throws ParseException, IOException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("Etc/GMT+5.5"));
        Date startTime = s.parse(slots.getStartTime());
        s.format(startTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.MINUTE, slots.getServiceTime());
        String newTime = s.format(cal.getTime());
        Date endTime = s.parse(newTime);
        s.format(endTime);

        Slots slots1 = new Slots(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME), startTime, endTime, slots.getEmployeeId(), slots.getServiceId(), slots.getServiceName(), slots.getServiceTime(), slots.getServiceImage(),
                slots.getEmployeeName(),
                slots.getEmployeeImage(),slots.getSlotTime());

        if (!appointmentService.getAppointmentsByEmployeeId(slots1.getEmployeeId()).isEmpty()) {
            List<Slots> list = appointmentService.getAppointmentsByEmployeeId(slots1.getEmployeeId());
            for (Slots l : list) {
                System.out.println(l);
                if (startTime.after(l.getStartTime()) && startTime.before(l.getEndTime())) {
                    System.out.println("c1" + l);
                    return new ResponseEntity<>("slot already booked", HttpStatus.OK);
                } else if (endTime.after(l.getStartTime()) && endTime.before(l.getEndTime())) {
                    System.out.println("c2" + l);
                    return new ResponseEntity<>("slot already booked", HttpStatus.OK);
                } else if (startTime.compareTo(l.getStartTime()) == 0 || endTime.compareTo(l.getEndTime()) == 0
                        || endTime.compareTo(l.getStartTime()) == 0 || startTime.compareTo(l.getEndTime()) == 0) {
                    System.out.println("c3" + l);
                    return new ResponseEntity<>("slot already booked", HttpStatus.OK);
                }
//                else if (startTime.before(l.getStartTime())) {
//                    if (endTime.before(l.getStartTime()))
//                        System.out.println("c4" + l);
//                    return new ResponseEntity<>("slot already booked", HttpStatus.OK);
//                }
            }
            return new ResponseEntity<>(appointmentService.createAppointment(slots1), HttpStatus.OK);
        }
        return new ResponseEntity<>(appointmentService.createAppointment(slots1), HttpStatus.OK);
//        throw new EmployeeIdNotFound();
        //return new ResponseEntity<>(appointmentService.createAppointment(slots1), HttpStatus.OK);
    }


    @PostMapping("/c")
    public ResponseEntity<?> create(@RequestParam String date) throws ParseException {
        SimpleDateFormat s=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=s.parse(date);
        System.out.println(date1);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    @PostMapping("/new-appointment")
    public ResponseEntity<?> createAppointments(@RequestBody SlotsDto slots) throws ParseException {
        SimpleDateFormat s=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("Etc/GMT+5.5"));
        Date startTime=s.parse(slots.getStartTime());
        s.format(startTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.MINUTE, slots.getServiceTime());
        String newTime = s.format(cal.getTime());
        Date endTime= s.parse(newTime);
        s.format(endTime);

        Slots slots1= new Slots(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME),startTime, endTime, slots.getEmployeeId(), slots.getServiceId(), slots.getServiceName(), slots.getServiceTime(), slots.getServiceImage(),
                slots.getEmployeeName(),
                slots.getEmployeeImage(),slots.getSlotTime());
        return new ResponseEntity<>(appointmentService.createAppointment(slots1),HttpStatus.OK);

    }

    @DeleteMapping("/delete-appointment/{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int appointmentId) throws AppointmentIdNotFound {
        try{
            return new ResponseEntity<>(appointmentService.deleteAppointment(appointmentId),HttpStatus.OK);}
        catch(AppointmentIdNotFound ex){
            throw new AppointmentIdNotFound();
        }
    }
    @PutMapping("/update-appointment")
    public ResponseEntity<?> updateAppointment(@RequestBody Slots slots) throws AppointmentIdNotFound {
        try{
            System.out.println("controller");
            return new ResponseEntity<>(appointmentService.updateAppointment(slots),HttpStatus.OK);}

        catch (AppointmentIdNotFound ex){
            throw new AppointmentIdNotFound();
        }
    }
    @GetMapping("/get-all-appointments")
    public ResponseEntity<?> getAllAppointment(){
        return new ResponseEntity<>(appointmentService.getAllAppointments(),HttpStatus.OK);
    }
    @GetMapping("/get-appointment-by-serviceId/{serviceId}")
    public ResponseEntity<?> getAppointmentsByServiceId(@PathVariable String serviceId) throws ServiceNotFound {
        try{
            return new ResponseEntity<>(appointmentService.getAppointmentsByServiceId(serviceId),HttpStatus.OK);}
        catch (ServiceNotFound ex){
            throw new ServiceNotFound();
        }
    }
    @GetMapping("/get-appointment-by-employeeId/{employeeId}")
    public ResponseEntity<?> getAppointmentsByEmployeeId(@PathVariable String employeeId) {
//        try{
            return new ResponseEntity<>(appointmentService.getAppointmentsByEmployeeId(employeeId),HttpStatus.OK);}
//        catch (EmployeeIdNotFound ex){
//            throw new EmployeeIdNotFound();
//        }

    @GetMapping("/{employeeId}/{date}")
    public ResponseEntity<?> getAppointmentsByEmployeeAndDate(@PathVariable String employeeId, @PathVariable String date) throws EmployeeIdNotFound{
        try {
            return new ResponseEntity<>(appointmentService.getAppointmentsByEmployeeAndDate(employeeId, date),HttpStatus.OK);
        }catch(EmployeeIdNotFound ex){
            throw new EmployeeIdNotFound();
        }
    }

    @GetMapping("/get-appointment-by-serviceId/{serviceId}/{date}")
    public ResponseEntity<?> getByServiceIdAndDate(@PathVariable String serviceId, @PathVariable String date) throws ServiceNotFound {
        try{
            return new ResponseEntity<>(appointmentService.getByServiceIdAndDate(serviceId, date),HttpStatus.OK);}
        catch (ServiceNotFound ex){
            throw new ServiceNotFound();
        }
    }
}