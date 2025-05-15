//package com.stackroute.apigateway;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.apigateway.controller.AuthenticationController;
//import com.stackroute.apigateway.exceptions.AuthenticationDetailsAlreadyExisting;
//import com.stackroute.apigateway.model.Authentication;
//import com.stackroute.apigateway.model.Employee;
//import com.stackroute.apigateway.model.User;
//import com.stackroute.apigateway.services.AuthenticationService;
//import com.stackroute.apigateway.services.SecurityTokenGenerator;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthenticationControllerTest {
//    public static String convertToJson(final Object object){
//        String result="";
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//            result=mapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private AuthenticationService authenticationService;
//
//    @InjectMocks
//    private AuthenticationController authenticationController;
//
//    private Authentication authentication;
//    private User user;
//
//    private Employee employee;
//
//    private SecurityTokenGenerator securityTokenGenerator;
//    @BeforeEach
//    public void setUp(){
//        user=new User("vijay@gmail.com","Vi@63019");
//        employee=new Employee("kiran@gmail.com","Ki@93472");
//        mockMvc= MockMvcBuilders.standaloneSetup(authenticationController).build();
//
//    }
//    @AfterEach
//    public void clean(){
//        authentication=null;
//        user=null;
//        employee=null;
//    }
//    @Test
//    public void testControllerAddAuthenticationDetailsUser() throws Exception {
//        System.out.println("hello");
//        authentication=new Authentication(user.getCustomerEmail(), user.getCustomerPassword(), "Role_User");
//        when(authenticationService.addUser(authentication)).thenReturn(authentication);
//        mockMvc.perform(
//                post("/authentication-app/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertToJson(user)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(authenticationService,times(1)).addUser(authentication);
//    }
//    @Test
//    public void testControllerAddAuthenticationDetailsUserFailure() throws Exception {
//        authentication=new Authentication(user.getCustomerEmail(), user.getCustomerPassword(), "Role_User");
//        when(authenticationService.addUser(authentication)).thenThrow(AuthenticationDetailsAlreadyExisting.class);
//        mockMvc.perform(
//                        post("/authentication-app/user")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(user)))
//                .andExpect(status().isAlreadyReported()).andDo(MockMvcResultHandlers.print());
//        verify(authenticationService,times(1)).addUser(authentication);
//    }
//    @Test
//    public void testControllerAddAuthenticationDetailsEmployee() throws Exception {
//        authentication=new Authentication(employee.getEmployeeEmail(),employee.getEmployeePassword(),"Role_Employee");
//        when(authenticationService.addUser(authentication)).thenReturn(authentication);
//        mockMvc.perform(
//                        post("/authentication-app/employee")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(employee)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(authenticationService,times(1)).addUser(authentication);
//    }
//    @Test
//    public void testControllerAddAuthenticationDetailsEmployeeFailure() throws Exception {
//
//        authentication=new Authentication(employee.getEmployeeEmail(),employee.getEmployeePassword(),"Role_Employee");
//        when(authenticationService.addUser(authentication)).thenThrow(AuthenticationDetailsAlreadyExisting.class);
//        mockMvc.perform(
//                        post("/authentication-app/employee")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(employee)))
//                .andExpect(status().isAlreadyReported()).andDo(MockMvcResultHandlers.print());
//        verify(authenticationService,times(1)).addUser(authentication);
//    }
//}
