package com.stackroute.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason ="Authentication Details Already Present")
public class AuthenticationDetailsAlreadyExisting extends Exception{
}
