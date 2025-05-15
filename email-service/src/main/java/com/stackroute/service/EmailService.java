package com.stackroute.service;

import com.stackroute.model.EmailData;

public interface EmailService {
    String sendSimpleMail(EmailData details);
}
