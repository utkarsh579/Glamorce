//package com.stackroute;
//import com.stackroute.model.Address;
//import com.stackroute.model.Gender;
//import com.stackroute.model.User;
//import com.stackroute.repository.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
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
//    @DisplayName("Test case for saving user object")
//    void givenUserSaveReturnsUserSaved(){
//        userRepository.save(user);
//        User user1 = userRepository.findById(user.getCustomerEmail()).get();
//        assertNotNull(user1);
//        assertEquals(user.getCustomerEmail(),user1.getCustomerEmail());
//    }
//    @Test
//    @DisplayName("Test case for deleting user object")
//    void givenUserDeleteReturnsUserDeleted(){
//        userRepository.save(user);
//        User user1 = userRepository.findById(user.getCustomerEmail()).get();
//        userRepository.delete(user1);
//        assertEquals(Optional.empty(),userRepository.findById(user1.getCustomerEmail()));
//    }
//    @Test
//    @DisplayName("Test case for getting all user")
//    public void givenUserForGetAllUserObject(){
//        userRepository.save(user);
//        Address address1 = new Address("110","brother place","gurugram","haryana","122221");
//        User user1 = new User("utkarsh1234@gmail.com","utkarsh1234","utkarsh",20,66666666666L,address1, Gender.Male,new byte[0]);
//        userRepository.save(user1);
//        List<User> userList = userRepository.findAll();
//        assertEquals(4,userList.size());
//        assertEquals("utkarsh1234@gmail.com",userList.get(0).getCustomerEmail());
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
