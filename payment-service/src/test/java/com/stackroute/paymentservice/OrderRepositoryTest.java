//package com.stackroute.paymentservice;
//
//import com.stackroute.paymentservice.model.OrderResponse;
//import com.stackroute.paymentservice.repository.OrderRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class OrderRepositoryTest {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    private OrderResponse orderResponse;
//
//    @BeforeEach
//    public void setup(){

//        orderResponse=new OrderResponse("pl_L5ZC89QhAXugQO","vijay@gmail.com","400",3,"vijay");

//        orderResponse=new OrderResponse("pl_L5ZC89QhAXugQO","vijay@gmail.com","400","3","vijay");

//    }
//
//    @AfterEach
//    public void clean(){
//        orderResponse=null;
//        orderRepository.deleteAll();
//    }
//
//    @Test
//    public void saveDetails(){
//        OrderResponse result=orderRepository.insert(orderResponse);
//        System.out.println(result.equals(orderResponse));
//        assertEquals(result,orderResponse);
//    }
//
//}
