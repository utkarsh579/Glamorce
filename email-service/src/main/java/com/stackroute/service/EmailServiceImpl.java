package com.stackroute.service;

import com.stackroute.model.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleMail(EmailData details)
    {
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setFrom("glamorcetest@gmail.com");
        mailMessage.setTo(details.getRecipient());
        mailMessage.setText(details.getMsgBody());
        mailMessage.setSubject(details.getSubject());
        System.out.println(mailMessage);
        javaMailSender.send(mailMessage);
        return "Mail Sent Successfully...";
    }
}
