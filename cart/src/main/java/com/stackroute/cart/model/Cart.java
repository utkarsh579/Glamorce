package com.stackroute.cart.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document
public class Cart {
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private int cartId;
    private int appointmentId;
    private String emailId;
    private String serviceId;
    private String serviceName;
    private int serviceTime;
    private String serviceDescription;
    private String servicePrice;
    private String employeeId;
    private String employeeName;
    private String proficiency;
    private String experience;
    private Date slotTime;
    private byte[] serviceImage;
}
