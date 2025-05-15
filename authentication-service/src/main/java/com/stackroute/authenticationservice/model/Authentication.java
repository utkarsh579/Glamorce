package com.stackroute.authenticationservice.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authentication {

    @Id
    private String emailId;
    private String password;
    private String role;
}
