//package com.stackroute.appointmentservice;
//
//import com.stackroute.appointmentservice.model.Slots;
//import com.stackroute.appointmentservice.repository.AppointmentRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class SlotsRepositoryTest {
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    private Slots slots;
//    String str = "service image";
//    String empImg="Employee Image";
//    byte array1[]=empImg.getBytes();
//    byte array[] = str.getBytes();
//    String startTime="05:30";
//    String endTime="06:30";
//    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//    Date d = df.parse(startTime);
//    Date e = df.parse(endTime);
//
//    public SlotsRepositoryTest() throws ParseException {
//    }
//
//    @BeforeEach
//    public void setUp(){
//
//        slots =new Slots(1,d,e,"abdul@gmail.com","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//    }
//    @AfterEach
//    public void clean(){
//        slots =null;
//        str=null;
//        empImg=null;
//        appointmentRepository.deleteAll();
//
//    }
//    @Test
//    public void addAppointmentDetails(){
//        Slots res=appointmentRepository.insert(slots);
//        assertEquals(res, slots);
//    }
//    @Test
//    public void findAllAppointments(){
//        appointmentRepository.insert(this.slots);
//        this.slots.setAppointmentId(3);
//        appointmentRepository.insert(this.slots);
//        List<Slots> slots =appointmentRepository.findAll();
//        assertEquals(2, slots.size());
//    }
//    @Test
//    public void deleteAppointment(){
//        appointmentRepository.insert(this.slots);
//        appointmentRepository.deleteByAppointmentId(this.slots.getAppointmentId());
//        List<Slots> slots =appointmentRepository.findAll();
//        assertEquals(0, slots.size());
//    }
//    @Test
//    public void getByServiceId(){
//        appointmentRepository.insert(this.slots);
//        appointmentRepository.getAppointmentsByServiceId(this.slots.getServiceId());
//        List<Slots> slots =appointmentRepository.findAll();
//        assertEquals(1, slots.size());
//    }
//    @Test
//    public void getByEmployeeId(){
//        appointmentRepository.insert(this.slots);
//        appointmentRepository.getAppointmentsByEmployeeId(this.slots.getEmployeeId());
//        List<Slots> slots =appointmentRepository.findAll();
//        assertEquals(1, slots.size());
//    }
//}
