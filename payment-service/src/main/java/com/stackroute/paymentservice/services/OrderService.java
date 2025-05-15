package com.stackroute.paymentservice.services;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.OrderNotFound;
import com.stackroute.paymentservice.model.OrderResponse;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {

    OrderResponse addOrderDetails(OrderResponse orderResponse);
    Order createRazorPayOrder(BigInteger amount) throws RazorpayException;

    List<OrderResponse> getByEmailId(String emailId) throws OrderNotFound;

}
