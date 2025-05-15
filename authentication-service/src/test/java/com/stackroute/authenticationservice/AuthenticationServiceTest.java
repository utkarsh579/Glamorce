//package com.stackroute.apigateway;
//
//import com.stackroute.apigateway.exceptions.AuthenticationDetailsAlreadyExisting;
//import com.stackroute.apigateway.exceptions.AuthenticationDetailsNotFound;
//import com.stackroute.apigateway.model.Authentication;
//import com.stackroute.apigateway.repository.AuthenticationRepository;
//import com.stackroute.apigateway.services.AuthenticationServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthenticationServiceTest {
//
//    @Mock
//    private AuthenticationRepository authenticationRepository;
//
//    @InjectMocks
//    private AuthenticationServiceImpl authenticationService;
//
//    private Authentication authentication;
//
//    @BeforeEach
//    public void setUp(){
//        authentication= new Authentication("vijay@gmail.com","Vi@63019","User");
//    }
//
//    @AfterEach
//    public void clean(){
//        authentication=null;
//    }
//    @Test
//    public void addDetailsSuccess() throws AuthenticationDetailsAlreadyExisting {
//        given(authenticationRepository.save(authentication)).willReturn(authentication);
//        System.out.println(authenticationService);
//        Authentication savedDetails=authenticationService.addUser(authentication);
//        System.out.println(savedDetails);
//        assertEquals(authentication,savedDetails);
//    }
//    @Test
//    public void addDetailsFailure(){
//        when(authenticationRepository.findById(authentication.getEmailId())).thenReturn(Optional.of(authentication));
//        assertThrows(AuthenticationDetailsAlreadyExisting.class,()->authenticationService.addUser(authentication));
//        verify(authenticationRepository,times(1)).findById(authentication.getEmailId());
//        verify(authenticationRepository,times(0)).save(authentication);
//    }
//    @Test
//    public void loginCheckSuccess() throws AuthenticationDetailsNotFound {
//        given(authenticationRepository.findById(authentication.getEmailId())).willReturn(Optional.of(authentication));
//        when(authenticationRepository.findByEmailIdAndPassword(authentication.getEmailId(), authentication.getPassword())).thenReturn(authentication);
//        Authentication authentications=authenticationService.loginCheck(authentication);
//        System.out.println(authentications);
//        assertEquals(authentications,authentication);
//    }
//}
