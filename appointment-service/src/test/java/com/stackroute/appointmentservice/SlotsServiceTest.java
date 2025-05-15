//package com.stackroute.appointmentservice;
//
//import com.stackroute.appointmentservice.exceptions.AppointmentIdNotFound;
//import com.stackroute.appointmentservice.exceptions.EmployeeIdNotFound;
//import com.stackroute.appointmentservice.exceptions.ServiceNotFound;
//import com.stackroute.appointmentservice.model.Slots;
//import com.stackroute.appointmentservice.repository.AppointmentRepository;
//import com.stackroute.appointmentservice.service.AppointmentServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class SlotsServiceTest {
//    @Mock
//    private AppointmentRepository appointmentRepository;
//
//    @InjectMocks
//    private AppointmentServiceImpl appointmentService;
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
//    public SlotsServiceTest() throws ParseException {
//    }
//
//    @BeforeEach
//    public void setUp(){
//
//        slots =new Slots(1,d,e,"abdul@gmail.com","SER001","Hair Cut",45,array,"Booked","Abdul",array1);
//    }
//    @AfterEach
//    public void clean(){
//        slots =null;
//        str=null;
//        empImg=null;
//        appointmentRepository.deleteAll();
//    }
//    @Test
//    public void testAddAppointment() throws ParseException {
//        when(appointmentRepository.insert(slots)).thenReturn(slots);
//        Slots slots1 =appointmentService.createAppointment(slots);
//        assertEquals(slots, slots1);
//    }
//    @Test
//    public void testDeleteAppointment() throws AppointmentIdNotFound {
//        when(appointmentRepository.findById(slots.getAppointmentId())).thenReturn(Optional.of(slots));
//        String res=appointmentService.deleteAppointment(slots.getAppointmentId());
//
//        assertEquals("Appointment Details Deleted",res);
//    }
//    @Test
//    public void testDeleteAppointmentFailure() throws AppointmentIdNotFound{
//        when(appointmentRepository.findById(slots.getAppointmentId())).thenReturn(Optional.ofNullable(null));
//        assertThrows(AppointmentIdNotFound.class,()->appointmentService.deleteAppointment(slots.getAppointmentId()));
//
//    }
//    @Test
//    public void testAppointmentByServiceId() throws ServiceNotFound{
//        when(appointmentRepository.getAppointmentsByServiceId(slots.getServiceId())).thenReturn(List.of(slots));
//       List<Slots> res= appointmentRepository.getAppointmentsByServiceId(slots.getServiceId());
//       assertEquals(1,res.size());
//
//    }
//    @Test
//    public void testAppointmentByServiceIdFailure() throws ServiceNotFound{
//        when(appointmentRepository.getAppointmentsByServiceId(slots.getServiceId())).thenReturn(List.of());
//        assertThrows(ServiceNotFound.class,()->appointmentService.getAppointmentsByServiceId(slots.getServiceId()));
//
//    }
//    @Test
//    public void testAppointmentByEmployeeId() throws EmployeeIdNotFound {
//        when(appointmentRepository.getAppointmentsByEmployeeId(slots.getEmployeeId())).thenReturn(List.of(slots));
//        List<Slots> res= appointmentRepository.getAppointmentsByEmployeeId(slots.getEmployeeId());
//        assertEquals(1,res.size());
//
//    }
//    @Test
//    public void testAppointmentByEmployeeIdFailure() throws ServiceNotFound{
//        when(appointmentRepository.getAppointmentsByEmployeeId(slots.getEmployeeId())).thenReturn(List.of());
//        assertThrows(EmployeeIdNotFound.class,()->appointmentService.getAppointmentsByEmployeeId(slots.getEmployeeId()));
//
//    }
//    }
//
