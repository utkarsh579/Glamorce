package com.stackroute.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Services {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private String serviceId;

    @NotNull
    @Size(min=4,message = "password should have at least 4 letters")

    private String serviceName;
    @NotNull
    private int serviceTime;
    @NotNull
    private int servicePrice;
    @NotNull
    @Size(min=8,message = "password should have atleast 8 letters")
    private String serviceDescription;
    private byte[] serviceImage;


}
