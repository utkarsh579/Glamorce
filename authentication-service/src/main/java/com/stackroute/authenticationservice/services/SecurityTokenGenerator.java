package com.stackroute.authenticationservice.services;



import com.stackroute.authenticationservice.model.Authentication;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(Authentication authentication);
}
