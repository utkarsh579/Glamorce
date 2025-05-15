package com.stackroute.paymentservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.OrderNotFound;
import com.stackroute.paymentservice.model.OrderRequest;
import com.stackroute.paymentservice.model.OrderResponse;
import com.stackroute.paymentservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
//@CrossOrigin(origins = "*")
public class RazorpayController {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderService orderService;
//    private String SECRET_ID1 = "rzp_test_ERxBHlTNtotw4m";
//    private String SECRET_KEY1 = "NwhzQxRHftfwJ1uV8iTeDQEo";
    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) throws RazorpayException {
        OrderResponse response=new OrderResponse();
        Order order=orderService.createRazorPayOrder(orderRequest.getAmount());
        System.out.println("---------------------------");
        String orderId = (String) order.get("id");
        System.out.println("Order ID: " + orderId);
        System.out.println("---------------------------");
        response.setEmailId(orderRequest.getEmail());
        response.setRazorpayOrderId(orderId);
//        response.setAppointmentId(orderRequest.getAppointmentId());
        response.setServiceFee("" + orderRequest.getAmount());
        response.setCustomerName(orderRequest.getCustomerName());
//        response.setSecretKey(SECRET_KEY1);
//        response.setSecretId(SECRET_ID1);
//        rabbitTemplate.convertAndSend("exchange_data","Payment",response);
        return new ResponseEntity<>(orderService.addOrderDetails(response), HttpStatus.OK);
    }


    @GetMapping("/order-details/{emailId}")
    public ResponseEntity<?> getByEmailId(@PathVariable String emailId) throws OrderNotFound {
        try {
            return new ResponseEntity<>(orderService.getByEmailId(emailId),HttpStatus.OK);
        } catch (OrderNotFound e) {
            throw new OrderNotFound();
        }
    }
}
