package com.stackroute.authenticationservice.services;

import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsAlreadyExisting;
import com.stackroute.authenticationservice.exceptions.AuthenticationDetailsNotFound;
import com.stackroute.authenticationservice.model.Authentication;
import com.stackroute.authenticationservice.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public Authentication addUser(Authentication authentication) throws AuthenticationDetailsAlreadyExisting {
        if (authenticationRepository.findById(authentication.getEmailId()).isEmpty()){
            return authenticationRepository.save(authentication);
        }else {
            throw new AuthenticationDetailsAlreadyExisting();
        }
    }

    @Override
    public Authentication loginCheck(Authentication authentication) throws AuthenticationDetailsNotFound {
        if (authenticationRepository.findById(authentication.getEmailId()).isPresent()){
            return authenticationRepository.findByEmailIdAndPassword(authentication.getEmailId(),authentication.getPassword());
        }
        else{
            throw new AuthenticationDetailsNotFound();
        }
    }
}
