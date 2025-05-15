//package com.stackroute.apigateway;
//
//import com.stackroute.apigateway.model.Authentication;
//import com.stackroute.apigateway.repository.AuthenticationRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class AuthenticationRepositoryTest {
//    @Autowired
//    private AuthenticationRepository authenticationRepository;
//
//    private Authentication authentication;
//
//    @BeforeEach
//    public void setup(){
//       authentication= new Authentication("vijay@gmail.com","Vi@63019","User");
//    }
//    @AfterEach
//    public void clean(){
//       authentication=null;
//        authenticationRepository.deleteAll();
//    }
//    @Test
//    public void saveDetails(){
//        Authentication result=authenticationRepository.save(authentication);
//        System.out.println(result.equals(authentication));
//        assertEquals(result,authentication);
//    }
//    @Test
//    public void findAllDetails(){
//        authenticationRepository.save(authentication);
//        authentication.setEmailId("surya@gmail.com");
//        authenticationRepository.save(authentication);
//        List<Authentication> authentications=authenticationRepository.findAll();
//        assertEquals(2,authentications.size());
//    }
//    @Test
//    public void testDeleteDetails(){
//        authenticationRepository.save(authentication);
//        authenticationRepository.deleteById(authentication.getEmailId());
//        List<Authentication> authentications=authenticationRepository.findAll();
//        System.out.println(authentications);
//        assertEquals(0,authentications.size());
//    }
//    @Test
//    public void testGetDetailsById(){
//        authenticationRepository.save(authentication);
//        Authentication result=authenticationRepository.findById(authentication.getEmailId()).get();
//        System.out.println(result.equals(authentication));
//        assertEquals(result,authentication);
//    }
//
//}
