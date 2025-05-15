package com.stackroute.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Employee with this email already exists")
public class EmployeeAlreadyExistsException extends Exception{
}
