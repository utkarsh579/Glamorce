package com.stackroute.authenticationservice.rabbitMq;


import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsAlreadyExisting;
import com.stackroute.authenticationservice.model.Authentication;
import com.stackroute.authenticationservice.model.Employee;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.services.AuthenticationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private AuthenticationService authenticationService;

    @RabbitListener(queues = "user-queue")
    public void getUser(User user) throws AuthenticationDetailsAlreadyExisting {
//        User user=new User(userSignupDTO.getCustomerName(), userSignupDTO.getCustomerEmail(),
//                userSignupDTO.getCustomerPassword(), userSignupDTO.getCustomerMobileNumber(),
//                userSignupDTO.getCustomerImage(),userSignupDTO.getAge(),userSignupDTO.getGender(),
//                userSignupDTO.getAddress());
        System.out.println(user);
        Authentication authenticationData=new Authentication(user.getCustomerEmail(),user.getCustomerPassword(),"User");
        System.out.println(authenticationService.addUser(authenticationData));
    }
    @RabbitListener(queues = "employee-queue")
    public void getEmployee(Employee employee) throws AuthenticationDetailsAlreadyExisting {
//        User user=new User(userSignupDTO.getCustomerName(), userSignupDTO.getCustomerEmail(),
//                userSignupDTO.getCustomerPassword(), userSignupDTO.getCustomerMobileNumber(),
//                userSignupDTO.getCustomerImage(),userSignupDTO.getAge(),userSignupDTO.getGender(),
//                userSignupDTO.getAddress());
        System.out.println(employee);
        Authentication authenticationData=new Authentication(employee.getEmployeeEmail(),employee.getEmployeePassword(),"Employee");
        System.out.println(authenticationService.addUser(authenticationData));
    }
}
