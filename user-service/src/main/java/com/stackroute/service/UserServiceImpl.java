package com.stackroute.service;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.model.Address;
import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getCustomerEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String customerEmail) {
        Optional<User> user = userRepository.findById(customerEmail);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public String deleteUser(String email) throws UserNotFoundException {
        if (userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(email);
        return "User_Deleted";
    }

    @Override
    public User updateUser(User user, String email) throws UserNotFoundException {
        Optional<User> checkId = userRepository.findById(email);
        if (checkId.isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.save(user);
    }


    @Override
    public User updateName(String name, String email) throws UserNotFoundException {
        Optional<User> user=userRepository.findById(email);

        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        User user1= user.get();
        user1.setName(name);
        return userRepository.save(user1);

    }

    @Override
    public User updateMobileNo(String mobileNo, String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user1 = user.get();
        user1.setMobileNo(Long.parseLong(mobileNo) );
        return userRepository.save(user1);
    }

    @Override
    public User updateAddress(Address address, String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user1 = user.get();
        user1.setAddress(address);
        return userRepository.save(user1);
    }

    @Override
    public User updateImage(byte[] profilePhoto, String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user1 = user.get();
        user1.setProfilePhoto(profilePhoto);
        return userRepository.save(user1);
    }


}







