//package com.stackroute;
//
//import com.icegreen.greenmail.util.GreenMail;
//import com.icegreen.greenmail.util.ServerSetup;
//import com.stackroute.model.EmailData;
//import com.stackroute.service.EmailService;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@SpringBootTest
//public class EmailServiceTest {
//
//    @Autowired
//    private EmailService emailService;
//
//    private EmailData data;
//
//    private GreenMail smtpServer;
//
//    //given
//   private String recipient;
//   private String message;
//   private String subject;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        //given
//        recipient = "abdulafreedi25@gmail.com";
//        message = "Test message content";
//        subject= "Glamorce Test";
//        smtpServer = new GreenMail(new ServerSetup(588, null, "smtp"));
//        smtpServer.start();
//    }
//    @AfterEach
//    public void tearDown() throws Exception {
//        smtpServer.stop();
//        recipient = null;
//        message = null;
//        subject= null;
//    }
//    @Test
//    public void shouldSendMail() throws Exception {
//
//        //when
//        String res=emailService.sendSimpleMail(new EmailData(recipient,message,subject));
//        //then
//        assertEquals("Mail Sent Successfully...", res);
//    }
//}
