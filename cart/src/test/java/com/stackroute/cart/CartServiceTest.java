//package com.stackroute.cart;
//
//import com.stackroute.cart.exception.CartIdNotFoundException;
//import com.stackroute.cart.exception.EmailIdNotFoundException;
//import com.stackroute.cart.model.Cart;
//import com.stackroute.cart.repository.CartRepository;
//import com.stackroute.cart.service.CartServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CartServiceTest {
//    @Mock
//    private CartRepository cartRepository;
//
//    @InjectMocks
//    private CartServiceImpl cartService;
//
//    private Cart cart;
//
//    String serImg="Service Image";
//    byte array1[]=serImg.getBytes();
//    String slotTime="10:30";
//    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//    Date d = df.parse(slotTime);
//
//    public CartServiceTest() throws ParseException {
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
//    @Test
//    public void addToCart(){
//        when(cartRepository.insert(cart)).thenReturn(cart);
//        Cart c =cartService.addToCart(cart);
//        assertEquals(cart, c);
//    }
//
//    @Test
//    public void getCartByEmailId() throws EmailIdNotFoundException {
//       when(cartRepository.getCartByEmailId(cart.getEmailId())).thenReturn(List.of(cart));
//       List<Cart> c= cartRepository.getCartByEmailId(cart.getEmailId());
//        assertEquals(1,c.size());
//    }
//
//    @Test
//    public void getCartByEmailIdFailure() throws EmailIdNotFoundException{
//        when(cartRepository.getCartByEmailId("surya@gmail.com")).thenReturn((List.of()));
//        assertThrows(EmailIdNotFoundException.class,()->cartService.getCartByEmailId("surya@gmail.com"));
//    }
//    @Test
//    public void deleteCartById() throws CartIdNotFoundException{
//        when(cartRepository.findById(10)).thenReturn(Optional.of(cart));
//       String res= cartService.deleteById(10);
//        assertEquals("Service removed from cart",res);
//    }
//    @Test
//    public void deleteCartByIdFailure() throws CartIdNotFoundException{
//        when(cartRepository.findById(12)).thenReturn(Optional.ofNullable(null));
//        assertThrows(CartIdNotFoundException.class,()->cartService.deleteById(12));
//    }
//}
