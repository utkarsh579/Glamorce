package com.stackroute.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document
public class User {

    @Id
    @NotNull
    @Email
    private String customerEmail;

    @NotNull
    @Size(min=4,message = "password should have atleast 4 letters")
    private String customerPassword ;

    @NotNull
    @Size(min=3,message = "name should have atleast 3 letters")
    private String name;

    private int age;

//    @Size(min=10,message = "mobile no should of 10 digit")
//    @Size(max=10,message = "mobile no should of 10 digit")
    private Long mobileNo;


    private Address address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    private byte[] profilePhoto;

}
