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
public class Employee {

    @Id
    @NotNull
    @Email
    private String employeeEmail;

    @NotNull
    @Size(min=4,message = "password should have atleast 8 letters")
    private String employeePassword;

    @NotNull
    @Size(min=3,message = "password should have atleast 3 letters")
    private String name;

    @NotNull
    @Min(value = 18, message = "age should be minimum 18")
    @Max(value = 36, message = "age should be minimum 48")
    private int age;

    @NotNull
    @Size(min=10,message = "mobile no should of 10 digit")
    @Size(max=10,message = "mobile no should of 10 digit")
    private String mobileNo;


    private String address;

    @NotNull
    private String experience;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Proficiency proficiency;

    private byte[] profilePhoto;

}
