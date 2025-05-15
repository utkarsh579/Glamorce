package com.stackroute.appointmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "EmployeeId Not Found")
public class EmployeeIdNotFound extends Exception{
}
