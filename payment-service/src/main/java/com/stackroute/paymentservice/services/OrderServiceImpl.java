package com.stackroute.paymentservice.services;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.OrderNotFound;
import com.stackroute.paymentservice.model.OrderResponse;
import com.stackroute.paymentservice.repository.OrderRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private RazorpayClient client;
    private String SECRET_ID1 = "rzp_test_ERxBHlTNtotw4m";
    private String SECRET_KEY1 = "NwhzQxRHftfwJ1uV8iTeDQEo";

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public OrderResponse addOrderDetails(OrderResponse orderResponse) {

        return orderRepository.insert(orderResponse);
    }

    @Override
    public Order createRazorPayOrder(BigInteger amount) throws RazorpayException {
        client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
        JSONObject options = new JSONObject();
        options.put("amount", amount.multiply(new BigInteger("100")));
        options.put("currency", "INR");
//        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1);

        return client.orders.create(options);
    }

    @Override
    public List<OrderResponse> getByEmailId(String emailId) throws OrderNotFound {
        if (!orderRepository.findByEmailId(emailId).isEmpty())
        {
            return orderRepository.findByEmailId(emailId);
        }
        else {
            throw new OrderNotFound();
        }

    }


}
