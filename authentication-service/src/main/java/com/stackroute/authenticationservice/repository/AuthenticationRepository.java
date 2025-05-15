package com.stackroute.authenticationservice.repository;
import com.stackroute.authenticationservice.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication,String> {
   Authentication findByEmailIdAndPassword(String emailId,String password);
}
