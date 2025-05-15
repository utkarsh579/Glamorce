//package com.stackroute;
//import com.stackroute.exceptions.UserAlreadyExistsException;
//import com.stackroute.exceptions.UserNotFoundException;
//import com.stackroute.model.Address;
//import com.stackroute.model.Gender;
//import com.stackroute.model.User;
//import com.stackroute.repository.UserRepository;
//import com.stackroute.service.UserServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.util.List;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserServiceImpl userService;
//    private User user;
//    private Address address;
//
//    @BeforeEach
//    void setUp(){
//        this.address = new Address("109","brother place","gurugram","haryana","122221");
//        this.user = new User("utkarsh123@gmail.com","utkarsh123","utkarsh",20,8998989898L,address, Gender.Male,new byte[0]);
//    }
//
//    @AfterEach
//    void clear(){
//        this.address = null;
//        this.user = null;
//    }
//
//    @Test
//    public void givenUserForSaveUserSuccess() throws UserAlreadyExistsException {
//        when(userRepository.findById(user.getCustomerEmail())).thenReturn(Optional.ofNullable(null));
//        when(userRepository.save(user)).thenReturn(user);
//        assertEquals(user,userService.registerUser(user));
//        verify(userRepository,times(1)).save(any());
//        verify(userRepository,times(1)).findById(any());
//    }
//    @Test
//    public void givenUserForSaveUserFailure(){
//        when(userRepository.findById(user.getCustomerEmail())).thenReturn(Optional.ofNullable(user));
//        assertThrows(UserAlreadyExistsException.class,()->userService.registerUser(user));
//        verify(userRepository,times(0)).save(any());
//        verify(userRepository,times(1)).findById(any());
//    }
//    @Test
//    public void givenUserForDeleteUserSuccess() throws UserNotFoundException {
//        when(userRepository.findById(user.getCustomerEmail())).thenReturn(Optional.ofNullable(user));
//        String result = userService.deleteUser(user.getCustomerEmail());
//        assertEquals("User_Deleted",result);
//        verify(userRepository,times(1)).deleteById(any());
//        verify(userRepository,times(1)).findById(any());
//    }
//    @Test
//    public void givenUserForDeleteUserFailure() {
//        when(userRepository.findById(user.getCustomerEmail())).thenReturn(Optional.ofNullable(null));
//        assertThrows(UserNotFoundException.class,()->userService.deleteUser(user.getCustomerEmail()));
//        verify(userRepository,times(0)).deleteById(any());
//        verify(userRepository,times(1)).findById(any());
//    }
//    @Test
//    public void givenUserForDisplayUserSuccess(){
//        when(userRepository.findAll()).thenReturn(List.of(new User("utkarsh123@gmail.com","utkarsh123","utkarsh",20,8998989898L,address, Gender.Male,new byte[0])));
//        assertEquals(List.of(new User("utkarsh123@gmail.com","utkarsh123","utkarsh",20,8998989898L,address, Gender.Male,new byte[0])),userService.getAllUser());
//        verify(userRepository,times(1)).findAll();
//    }
//    @Test
//    public void givenUserForDisplayUserFailure(){
//        when(userRepository.findAll()).thenReturn(List.of());
//        assertEquals(List.of(),userService.getAllUser());
//        verify(userRepository,times(1)).findAll();
//    }
//
//}
