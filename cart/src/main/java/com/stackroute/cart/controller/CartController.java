package com.stackroute.cart.controller;

import com.stackroute.cart.exception.CartIdNotFoundException;
import com.stackroute.cart.exception.EmailIdNotFoundException;
import com.stackroute.cart.model.Cart;
import com.stackroute.cart.model.CartDto;
import com.stackroute.cart.service.CartService;
import com.stackroute.cart.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.stackroute.cart.model.Cart.SEQUENCE_NAME;

@RestController
@RequestMapping("/cart")
//@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartDto cart) throws ParseException {
        SimpleDateFormat s=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s.setTimeZone(TimeZone.getTimeZone("Etc/GMT+5.5"));
        Date time=s.parse(cart.getSlotTime());

        cart.setCartId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        Cart cart1=new Cart(cart.getCartId(), cart.getAppointmentId(), cart.getEmailId(), cart.getServiceId(), cart.getServiceName(), cart.getServiceTime(), cart.getServiceDescription(), cart.getServicePrice(), cart.getEmployeeId(), cart.getEmployeeName(),cart.getProficiency(),cart.getExperience(),time, cart.getServiceImage());

        return new ResponseEntity<>(cartService.addToCart(cart1), HttpStatus.OK);
    }

    @GetMapping("/get/{emailId}")
    public ResponseEntity<?> getCartByEmailId(@PathVariable String emailId) throws EmailIdNotFoundException {
        try{
            return new ResponseEntity<>(cartService.getCartByEmailId(emailId),HttpStatus.OK);
        }
        catch (EmailIdNotFoundException ex){
            throw new EmailIdNotFoundException();
        }
    }

    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<?> deleteById(@PathVariable int cartId) throws CartIdNotFoundException{
        try{
            return new ResponseEntity<>(cartService.deleteById(cartId),HttpStatus.OK);
        }
        catch (CartIdNotFoundException ex){
            throw new CartIdNotFoundException();
        }
    }

    @DeleteMapping("/remove-all-by-emailId/{emailId}")
    public ResponseEntity<?> deleteAll(@PathVariable String emailId)
    {
        return new ResponseEntity<>(cartService.deleteAllByEmailId(emailId),HttpStatus.OK);
    }
}
