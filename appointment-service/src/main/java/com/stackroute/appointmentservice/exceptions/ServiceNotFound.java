package com.stackroute.appointmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Service ID Not Found")
public class ServiceNotFound extends Exception{
}
