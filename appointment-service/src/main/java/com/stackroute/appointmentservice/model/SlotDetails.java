package com.stackroute.appointmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class SlotDetails {
    private String appointmentId;
    private String employeeId;
    private String serviceId;
    private String serviceName;
    private int serviceTime;
    private String slotTime;
    private byte[] serviceImage;
    private String servicePrice;
    private String employeeName;
    private String employeeProficiency;
}
