package com.stackroute.authenticationservice.services;
import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsAlreadyExisting;
import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsNotFound;
import com.stackroute.authenticationservice.model.Authentication;

public interface AuthenticationService {
    Authentication addUser(Authentication authentication) throws AuthenticationDetailsAlreadyExisting;
    Authentication loginCheck(Authentication authentication) throws AuthenticationDetailsNotFound;
}
