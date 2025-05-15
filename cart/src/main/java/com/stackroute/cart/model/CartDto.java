package com.stackroute.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class CartDto
{
    private int cartId;
    private int appointmentId;
    private String emailId;
    private String serviceId;
    private String serviceName;
    private int serviceTime;
    private String serviceDescription;
    private String servicePrice;
    private String employeeName;
    private String employeeId;
    private String proficiency;
    private String experience;
    private String slotTime;
    private byte[] serviceImage;
}
