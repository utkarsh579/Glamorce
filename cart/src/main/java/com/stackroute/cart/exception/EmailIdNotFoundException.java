package com.stackroute.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "EmailId Not Found")
public class EmailIdNotFoundException extends Exception{

}
