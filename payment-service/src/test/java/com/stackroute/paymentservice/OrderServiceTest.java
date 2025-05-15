//package com.stackroute.paymentservice;
//
//import com.stackroute.paymentservice.model.OrderResponse;
//import com.stackroute.paymentservice.repository.OrderRepository;
//import com.stackroute.paymentservice.services.OrderServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class OrderServiceTest {
//
//    @Mock
//    private OrderRepository orderRepository;
//
//    @InjectMocks
//    private OrderServiceImpl orderService;
//
//    private OrderResponse orderResponse;
//
//
//    @BeforeEach
//    public void setUp(){
//        orderResponse=new OrderResponse("pl_L5ZC89QhAXugQO","vijay@gmail.com","400",3,"vijay");

//        orderResponse=new OrderResponse("pl_L5ZC89QhAXugQO","vijay@gmail.com","400","3","vijay");

//    }
//
//    @AfterEach
//    public void clean(){
//        orderResponse=null;
//        orderRepository.deleteAll();
//    }
//    @Test
//    public void AddOrder(){
//        when(orderRepository.insert(orderResponse)).thenReturn(orderResponse);
//        OrderResponse orderResponse1=orderService.addOrderDetails(orderResponse);
//        assertEquals(orderResponse,orderResponse1);
//    }
//}
