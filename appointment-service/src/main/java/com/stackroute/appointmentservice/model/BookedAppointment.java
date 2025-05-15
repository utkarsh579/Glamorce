package com.stackroute.appointmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.util.Date;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class BookedAppointment {
//    @Transient
//    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private String bookedAppointmentId;
    private Date startTime;
//    private Date endTime;
    private String userId;
    private List<SlotDetails> serviceDetailsList;
}
