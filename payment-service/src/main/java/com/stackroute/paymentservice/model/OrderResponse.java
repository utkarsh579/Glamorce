package com.stackroute.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class OrderResponse {
    @Id
    private String razorpayOrderId;
    private String emailId;
    private String serviceFee;
//    private String appointmentId;
    private String customerName;
}
