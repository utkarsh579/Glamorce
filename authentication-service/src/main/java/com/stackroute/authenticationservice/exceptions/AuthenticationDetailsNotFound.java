package com.stackroute.authenticationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Authentication Details Not Found")
public class AuthenticationDetailsNotFound extends Exception{
}
