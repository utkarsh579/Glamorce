package com.stackroute.feedbackservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback
{

    @Transient
    public static final String SEQUENCE_NAME="feedBack_sequence";
    @Id
    private String feedBackId;

    private String appointmentId;
    @NotEmpty(message = "Please enter proper name")
    @Size(min=3, message = "Name should be at least 3 characters")
    @Size(max=15, message = "Name should not be greater than 15 characters")
    private String name;
    @NotEmpty(message = "Please enter comment")
    @Size(min=8, message = "Comments should be at least 8 characters")
    @Size(max=100, message = "Comments should not be greater than 100 characters")
    private String comments;
    @NotNull(message = "Please Give review")
    @Min(value=1, message = "Review is must must be ")
    @Max(value=5, message = "Review should not be greater than 5")
    private int rating;
}
