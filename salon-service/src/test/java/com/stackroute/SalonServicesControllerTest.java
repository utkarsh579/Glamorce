//package com.stackroute;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.controller.SalonServicesController;
//import com.stackroute.exception.ServiceNotAddedException;
//import com.stackroute.exception.ServiceNotFoundException;
//import com.stackroute.model.Services;
//import com.stackroute.service.SalonServicesServiceImpl;
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
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@ExtendWith(MockitoExtension.class)
//public class SalonServicesControllerTest
//{
//    @Mock
//    private SalonServicesServiceImpl salonServicesService;
//    @InjectMocks
//    private SalonServicesController salonServicesController;
//
//    @Autowired
//    private MockMvc mockMvc;
//    private Services services;
//
//
//    @BeforeEach
//    void setUp() {
//
//        this.services = new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1);
//        mockMvc = MockMvcBuilders.standaloneSetup(salonServicesController).build();
//    }
//
//    @AfterEach
//    void clear() {
//
//        this.services = null;
//    }
//
//    @Test
//    public void serviceSavedSuccess() throws Exception
//    {
//        when(salonServicesService.addService(any())).thenReturn(services);
//        mockMvc.perform(post("/service/add-service")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(services)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void serviceSavedFailure() throws Exception {
//        when(salonServicesService.addService(any())).thenThrow(ServiceNotAddedException.class);
//        mockMvc.perform(post("/service/add-service")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(services)))
//                .andExpect(status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteServiceSuccess() throws Exception {
//        when(salonServicesService.deleteService(anyString())).thenReturn("Service Deleted");
//        mockMvc.perform(delete("/service/delete-service-by-id/S002")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteServiceFailure() throws Exception {
//        when(salonServicesService.deleteService(anyString())).thenThrow(ServiceNotFoundException.class);
//        mockMvc.perform(delete("/service/delete-service-by-id/S002")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void getAllServicesSuccess() throws Exception {
//        when(salonServicesService.getAllServices()).thenReturn(List.of(new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1)));
//        mockMvc.perform(get("/service/get-all-services")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(services)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void getAllServicesFailure() throws Exception {
//        when(salonServicesService.getAllServices()).thenReturn(null);
//        mockMvc.perform(get("/service/get-all-services")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(services)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String jsonToString(final Object object){
//        String result;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonContent = mapper.writeValueAsString(object);
//            result = jsonContent;
//        } catch (JsonProcessingException e) {
//            result = "json parser error";
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}
