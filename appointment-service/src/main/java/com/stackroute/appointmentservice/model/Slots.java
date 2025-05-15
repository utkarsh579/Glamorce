package com.stackroute.appointmentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "appointments")
public class Slots {
    //    @Id
//    UUID appointId = UUID.randomUUID();
//    @Id
//    private String appointmentId = RandomStringUtils.random(4, true, false);
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private int appointmentId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
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
//    private boolean status;
    @NotEmpty
    @Size(min = 3, message = "user name should have at least 3 characters")
    private String employeeName;
    private byte[] employeeImage;

    private String slotTime;
}
