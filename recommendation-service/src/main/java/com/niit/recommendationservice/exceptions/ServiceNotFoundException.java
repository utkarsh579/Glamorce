package com.niit.recommendationservice.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Service searched not found")
public class ServiceNotFoundException extends Exception{
}
