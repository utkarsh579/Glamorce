package com.stackroute.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee with this email do not exist")
public class EmployeeNotFoundException extends Exception{
}
