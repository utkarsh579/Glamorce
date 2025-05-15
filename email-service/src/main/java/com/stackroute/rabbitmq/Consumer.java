package com.stackroute.rabbitmq;

import com.stackroute.model.EmailData;
import com.stackroute.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "mail_queue")
    public  void  getDtoSendMail(String customerEmail){
        EmailData emailDetails=new EmailData();
        emailDetails.setRecipient(customerEmail);
        emailDetails.setSubject("Glamorce: Registration");
        emailDetails.setMsgBody("Thank You for registering with Glamorce, Looking forward to see you at salon :)");
        System.out.println(emailService.sendSimpleMail(emailDetails));
    }

//    @RabbitListener(queues = "book_queue")
//    public  void  sendMailAfterBooking(String customerEmail){
//        EmailData emailDetails=new EmailData();
//        emailDetails.setRecipient(customerEmail);
//        emailDetails.setSubject("Glamorce: Appointment Confirmed");
//        emailDetails.setMsgBody("Thank You for booking an appointment, Looking forward to see you at salon :)");
//        System.out.println(emailService.sendSimpleMail(emailDetails));
//    }

}
