//package com.stackroute.cart;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.cart.controller.CartController;
//import com.stackroute.cart.exception.CartIdNotFoundException;
//import com.stackroute.cart.exception.EmailIdNotFoundException;
//import com.stackroute.cart.model.Cart;
//import com.stackroute.cart.service.CartService;
//import com.stackroute.cart.service.SequenceGeneratorService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static com.stackroute.cart.model.Cart.SEQUENCE_NAME;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class CartControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private CartService cartService;
//
//    @Mock
//    private SequenceGeneratorService sequenceGeneratorService;
//
//    @InjectMocks
//    private CartController cartController;
//
//    private Cart cart;
//
//    String serImg="Service Image";
//    byte array1[]=serImg.getBytes();
//    String slotTime="10:30";
//    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//    Date d = df.parse(slotTime);
//
//    public CartControllerTest() throws ParseException {
//    }
//
//
//    @BeforeEach
//    public void setUp(){
//        cart =new Cart(10,"abdul@gmail.com","Hair Cut",45,"Very good service","450","Vijay","Hair","10 years",d,array1);
//        mockMvc= MockMvcBuilders.standaloneSetup(cartController).build();
//    }
//    @AfterEach
//    public void clean() {
//        cart = null;
//        slotTime = null;
//        d = null;
//    }
//
//    public static String convertToJson(final Object object){
//        String result="";
//        ObjectMapper mapper=new ObjectMapper();
//        try {
//            result=mapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//    @Test
//    public void addToCart() throws Exception {
//    cart.setCartId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
//    when(cartService.addToCart(cart)).thenReturn(cart);
//        mockMvc.perform(
//                        post("/cart/add")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(cart)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void getCartByEmailId() throws Exception {
//       cart=new Cart(10,"abdul@gmail","Hair Cut",45,"Very good service","450","Vijay","Hair","10 years",d,array1);
//        List<Cart> c=cartService.getCartByEmailId("abdul@gmail");
//        when(cartService.getCartByEmailId(cart.getEmailId())).thenReturn(c);
//        mockMvc.perform(
//                        get("/cart/get/abdul@gmail")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(this.cart)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//
//    }
//
//    @Test
//    public void deleteCartById() throws Exception {
//        when(cartService.deleteById(cart.getCartId())).thenReturn("Service removed from cart");
//        mockMvc.perform(
//                        delete("/cart/remove/10")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(cart)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteCartByIdFailure() throws Exception{
//        when(cartService.deleteById(cart.getCartId())).thenThrow(CartIdNotFoundException.class);
//        mockMvc.perform(
//                        delete("/cart/remove/10")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(cart)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getCartByEmailIdFailure() throws Exception{
//        cart=new Cart(10,"abdul@gmail","Hair Cut",45,"Very good service","450","Vijay","Hair","10 years",d,array1);
//        List<Cart> c=cartService.getCartByEmailId("abdul@gmail");
//        when(cartService.getCartByEmailId(cart.getEmailId())).thenThrow(EmailIdNotFoundException.class);
//        mockMvc.perform(
//                        get("/cart/get/abdul@gmail")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(cart)))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//    }
//
//}
