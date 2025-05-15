//package com.stackroute.cart;
//
//import com.stackroute.cart.model.Cart;
//import com.stackroute.cart.repository.CartRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class CartRepositoryTest {
//    @Autowired
//    private CartRepository cartRepository;
//
//    private Cart cart;
//
//    String serImg="Service Image";
//    byte array1[]=serImg.getBytes();
//    String slotTime="10:30";
//    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//    Date d = df.parse(slotTime);
//
//
//    public CartRepositoryTest() throws ParseException {
//    }
//
//    @BeforeEach
//    public void setUp(){
//
//        cart =new Cart(10,"abdul@gmail.com","Hair Cut",45,"Very good service","450","Vijay","Hair","10 years",d,array1);
//    }
//    @AfterEach
//    public void clean() {
//        cart = null;
//        slotTime = null;
//        d = null;
//        cartRepository.deleteAll();
//    }
//
//    @Test
//    public void addToCart(){
//        Cart c=cartRepository.insert(cart);
//        assertEquals(c,cart);
//    }
//
//    @Test
//    public void getCartByEmailId(){
//        cartRepository.insert(cart);
//        List<Cart> c= cartRepository.getCartByEmailId(cart.getEmailId());
//        assertEquals(1, c.size());
//    }
//
//    @Test
//    public void deleteCartById(){
//        cartRepository.insert(cart);
//        cartRepository.deleteById(10);
//        List<Cart> c =cartRepository.findAll();
//        assertEquals(0, c.size());
//    }
//}
