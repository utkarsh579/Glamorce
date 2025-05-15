package com.stackroute.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "CartId Not Found")
public class CartIdNotFoundException extends Exception{
}
