package com.stackroute.controller;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.model.Address;
import com.stackroute.model.User;
import com.stackroute.service.IUserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;



@RestController
@RequestMapping("user")
//@CrossOrigin(origins = "*")
public class UserController {

    private IUserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody User user) throws UserAlreadyExistsException {
        rabbitTemplate.convertAndSend("exchange_data", "register-user", user);
        rabbitTemplate.convertAndSend("exchange_data", "email-send", user.getCustomerEmail());
        try {
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }


    @GetMapping("/user/{customerEmail}")
    public ResponseEntity<?> getUser(@PathVariable String customerEmail) {
        return new ResponseEntity<>(userService.getUser(customerEmail), HttpStatus.OK);
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) throws UserNotFoundException {
        try {
            return new ResponseEntity<>(userService.deleteUser(email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }


    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@Valid @RequestParam("user") String user, @RequestParam("profilePhoto") MultipartFile file, @PathVariable String email) throws UserNotFoundException, IOException, JsonParseException, JsonMappingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user1 = objectMapper.readValue(user, User.class);
            byte[] image = file.getBytes();
            user1.setProfilePhoto(image);
            return new ResponseEntity<>(userService.updateUser(user1, email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

    @PatchMapping("/user/name")
    public ResponseEntity<?> UpdateName(@RequestParam String emailId, @RequestBody String name) throws UserNotFoundException {
        try {
            return new ResponseEntity<>(userService.updateName(name, emailId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

    @PatchMapping("/user/mobileNo")
    public ResponseEntity<?> UpdateMobileNo(@RequestParam String emailId, @RequestBody String mobileNo) throws UserNotFoundException {
        try {
            return new ResponseEntity<>(userService.updateMobileNo(mobileNo, emailId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }


    @PatchMapping("/user/address")
    public ResponseEntity<?> UpdateAddress(@RequestParam String emailId, @RequestBody Address address) throws UserNotFoundException {
        try {
            return new ResponseEntity<>(userService.updateAddress(address, emailId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
    }

    @PatchMapping("/user/image")
    public ResponseEntity<?> UpdateImage(@RequestParam String emailId, @RequestParam("profilePhoto") MultipartFile file) throws UserNotFoundException {
        try {
            byte[] image = file.getBytes();
            return new ResponseEntity<>(userService.updateImage(image, emailId), HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}








