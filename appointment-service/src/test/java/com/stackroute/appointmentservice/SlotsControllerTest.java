//package com.stackroute.appointmentservice;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.appointmentservice.controller.AppointmentController;
//import com.stackroute.appointmentservice.exceptions.AppointmentIdNotFound;
//import com.stackroute.appointmentservice.exceptions.EmployeeIdNotFound;
//import com.stackroute.appointmentservice.exceptions.ServiceNotFound;
//import com.stackroute.appointmentservice.model.Slots;
//import com.stackroute.appointmentservice.service.AppointmentService;
//import com.stackroute.appointmentservice.service.SequenceGeneratorService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static com.stackroute.appointmentservice.model.Slots.SEQUENCE_NAME;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class SlotsControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private AppointmentService appointmentService;
//    @Mock
//    private SequenceGeneratorService sequenceGeneratorService;
//    @InjectMocks
//    private AppointmentController appointmentController;
//
//    private Slots slots;
//
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
//    public SlotsControllerTest() throws ParseException {
//    }
//
//    @BeforeEach
//    public void setUp(){
//
//        slots =new Slots(1,d,e,"abdul@gmail.com","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//        mockMvc= MockMvcBuilders.standaloneSetup(appointmentController).build();
//    }
//    @AfterEach
//    public void clean(){
//        slots =null;
//        str=null;
//        empImg=null;
//    }
//    public static String convertToJson(final Object object){
//        String result="";
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//            result=mapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//    @Test
//    public void testCreateAppointment() throws Exception {
//        slots.setAppointmentId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
//        when(appointmentService.createAppointment(slots)).thenReturn(slots);
//        mockMvc.perform(
//                post("/appointment/create-appointment")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertToJson(slots)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void testDeleteAppointment() throws Exception{
//    when(appointmentService.deleteAppointment(slots.getAppointmentId())).thenReturn("Appointment Details Deleted");
//    mockMvc.perform(
//            delete("/appointment/delete-appointment/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertToJson(slots)))
//            .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//
//    }
//    @Test
//    public void testDeleteAppointmentFailure() throws Exception{
//        when(appointmentService.deleteAppointment(slots.getAppointmentId())).thenThrow(AppointmentIdNotFound.class);
//        mockMvc.perform(
//                        delete("/appointment/delete-appointment/1")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(slots)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//
//    }
//    @Test
//    public void testAppointmentServiceId() throws Exception{
//        this.slots =new Slots(2,d,e,"abdul@gmail.com","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//        List<Slots> slots = appointmentService.getAppointmentsByServiceId("SER001");
//        when(appointmentService.getAppointmentsByServiceId(this.slots.getServiceId())).thenReturn(slots);
//        mockMvc.perform(
//                        get("/appointment/get-appointment-by-serviceId/SER001")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(this.slots)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//
//    }
//    @Test
//    public void testAppointmentServiceIdFailure() throws Exception{
//        this.slots =new Slots(2,d,e,"abdul@gmail.com","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//        List<Slots> slots = appointmentService.getAppointmentsByServiceId("SER001");
//        when(appointmentService.getAppointmentsByServiceId(this.slots.getServiceId())).thenThrow(ServiceNotFound.class);
//        mockMvc.perform(
//                        get("/appointment/get-appointment-by-serviceId/SER001")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(this.slots)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//
//    }
//    @Test
//    public void testAppointmentEmployeeIdFailure() throws Exception{
//        slots =new Slots(2,d,e,"abdul@gmail","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//        //List<Appointment> appointments = appointmentService.getAppointmentsByEmployeeId("abdul@gmail.com");
//
//        when(appointmentService.getAppointmentsByEmployeeId(slots.getEmployeeId())).thenThrow(EmployeeIdNotFound.class);
//        mockMvc.perform(
//                        get("/appointment/get-appointment-by-employeeId/abdul@gmail")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(slots)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//
//    }
//    @Test
//    public void testAppointmentEmployeeId() throws Exception{
//        this.slots =new Slots(2,d,e,"abdul@gmail","SER001","Hair Cut",60,array,"Booked","Abdul",array1);
//       List<Slots> slots = appointmentService.getAppointmentsByEmployeeId("abdul@gmail");
//
//        when(appointmentService.getAppointmentsByEmployeeId(this.slots.getEmployeeId())).thenReturn(slots);
//        mockMvc.perform(
//                        get("/appointment/get-appointment-by-employeeId/abdul@gmail")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(this.slots)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//}
