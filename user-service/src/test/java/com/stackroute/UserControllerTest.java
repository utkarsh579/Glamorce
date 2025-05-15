//package com.stackroute;
//import com.stackroute.controller.UserController;
//import com.stackroute.exceptions.UserAlreadyExistsException;
//import com.stackroute.exceptions.UserNotFoundException;
//import com.stackroute.model.Address;
//import com.stackroute.model.Gender;
//import com.stackroute.model.User;
//import com.stackroute.service.UserServiceImpl;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
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
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import java.util.List;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//
//    @Mock
//    private UserServiceImpl userService;
//    @InjectMocks
//    private UserController userController;
//
//    @Autowired
//    private MockMvc mockMvc;
//    private User user;
//    private Address address;
//
//    @BeforeEach
//    void setUp(){
//        this.address = new Address("109","brother place","gurugram","haryana","122221");
//        this.user = new User("utkarsh123@gmail.com","utkarsh123","utkarsh",20,8998989898L,address, Gender.Male,new byte[0]);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//
//    @AfterEach
//    void clear(){
//        this.address = null;
//        this.user = null;
//    }
//
//    @Test
//    public void givenUserToReturnSavedSuccess() throws Exception {
//        when(userService.registerUser(any())).thenReturn(user);
//        mockMvc.perform(post("/api/v1/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(user)))
//                .andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenUserToReturnSavedFailure() throws Exception {
//        when(userService.registerUser(any())).thenThrow(UserAlreadyExistsException.class);
//        mockMvc.perform(post("/api/v1/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(user)))
//                .andExpect(status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenUserToReturnDeleteSuccess() throws Exception {
//        when(userService.deleteUser(anyString())).thenReturn("User_Deleted");
//        mockMvc.perform(delete("/api/v1/user/utkarsh123@gmail.com")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isGone())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenUserToReturnDeleteFailure() throws Exception {
//        when(userService.deleteUser(anyString())).thenThrow(UserNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/user/utkarsh123@gmail.com")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenUserToReturnDisplaySuccess() throws Exception {
//        when(userService.getAllUser()).thenReturn(List.of(new User("utkarsh123@gmail.com","utkarsh123",
//                "utkarsh",20,8998989898L,address, Gender.Male,new byte[0])));
//        mockMvc.perform(get("/api/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(user)))
//                .andExpect(status().isFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenUserToReturnDisplayFailure() throws Exception {
//        when(userService.getAllUser()).thenReturn(null);
//        mockMvc.perform(get("/api/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(user)))
//                .andExpect(status().isFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String jsonToString(final Object object){
//        String result;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonContent = mapper.writeValueAsString(object);
//            result = jsonContent;
//        } catch (JsonProcessingException e) {
//            result = "json parser error";
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//}
