package com.stackroute.service;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.model.Address;
import com.stackroute.model.User;
import java.util.List;


public interface IUserService {

    User registerUser (User user) throws UserAlreadyExistsException;
    List<User> getAllUser();

    User getUser(String customerEmail);
    String deleteUser(String email) throws UserNotFoundException;
    User updateUser(User user, String email) throws UserNotFoundException;

    User updateName(String name, String email) throws UserNotFoundException;
    User updateMobileNo(String mobileNo, String email) throws UserNotFoundException;
    User updateAddress(Address address, String email) throws UserNotFoundException;

 User updateImage(byte[] profilePhoto, String email) throws UserNotFoundException;



}
