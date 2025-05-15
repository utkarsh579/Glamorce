//package com.stackroute;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.controller.EmailController;
//import com.stackroute.model.EmailData;
//import com.stackroute.service.EmailService;
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
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class EmailControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private EmailService emailService;
//
//    @InjectMocks
//    private EmailController emailController;
//
//    private EmailData emailData;
//
//    private String recipient;
//    private String message;
//    private String subject;
//
//    @BeforeEach
//    public void setUp(){
//        recipient = "abdulafreedi25@gmail.com";
//        message = "Test message content";
//        subject= "Glamorce  Controller Test";
//        emailData=new EmailData(recipient,message,subject);
//        mockMvc= MockMvcBuilders.standaloneSetup(emailController).build();
//    }
//    @AfterEach
//    public void clean(){
//        emailData=null;
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
//
//    @Test
//    public void testToSendMail() throws Exception {
//    when(emailService.sendSimpleMail(emailData)).thenReturn("Mail Sent Successfully...");
//        mockMvc.perform(
//                        post("/email/sendMail")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(emailData)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//}
