package com.niit.recommendationservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Service already exists")
public class ServiceAlreadyExistsException extends Exception{
}
