package com.stackroute.appointmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SlotsDto {
    //    @Id
//    UUID appointId = UUID.randomUUID();
//    @Id
//    private String appointmentId = RandomStringUtils.random(4, true, false);
    private int appointmentId;
    private String startTime;


    private String endTime;
    @NotEmpty
    @Email
    private String employeeId;
    @NotEmpty
//    @Size(min = 3, message = "user name should have at least 3 characters")
    private String serviceId;
    @NotEmpty
    @Size(min = 3, message = "user name should have at least 3 characters")
    private String serviceName;


    private int serviceTime;



    private byte[] serviceImage;
//    @NotEmpty
//    private String status;
    @NotEmpty
    @Size(min = 3, message = "user name should have at least 3 characters")
    private String employeeName;

    private String proficiency;
    private byte[] employeeImage;

   private String slotTime;
}
