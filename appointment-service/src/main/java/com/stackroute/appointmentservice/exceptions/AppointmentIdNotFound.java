package com.stackroute.appointmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "AppointmentId Not Found")
public class AppointmentIdNotFound extends Exception {
}
