package com.stackroute.authenticationservice.controller;


import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsAlreadyExisting;
import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsNotFound;
import com.stackroute.authenticationservice.model.Authentication;
import com.stackroute.authenticationservice.model.Employee;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.services.AuthenticationService;
import com.stackroute.authenticationservice.services.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/authentication-app")
@RestController
//@CrossOrigin(origins = "*")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService)
    {
        this.authenticationService=authenticationService;
    }

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@Valid  @RequestBody User user) throws AuthenticationDetailsAlreadyExisting {
        Authentication authenticationData=new Authentication(user.getCustomerEmail(),user.getCustomerPassword(),"Role_User");
        try {
            return new ResponseEntity<>(authenticationService.addUser(authenticationData), HttpStatus.OK);
        } catch (AuthenticationDetailsAlreadyExisting e) {
            throw new AuthenticationDetailsAlreadyExisting();
        }
    }
    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) throws AuthenticationDetailsAlreadyExisting {
        Authentication authenticationData=new Authentication(employee.getEmployeeEmail(), employee.getEmployeePassword(), "Role_Employee");
        try {
            return new ResponseEntity<>(authenticationService.addUser(authenticationData), HttpStatus.OK);
        } catch (AuthenticationDetailsAlreadyExisting e) {
            throw new AuthenticationDetailsAlreadyExisting();
        }
    }
    @PostMapping("/login-check")
    public ResponseEntity<?> loginCheck(@RequestBody Authentication authentication) throws AuthenticationDetailsNotFound {
        Authentication result = authenticationService.loginCheck(authentication);

        if (result!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(result),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Authentication failed",HttpStatus.OK);
        }
    }
}
