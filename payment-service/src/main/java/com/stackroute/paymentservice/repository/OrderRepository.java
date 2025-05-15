package com.stackroute.paymentservice.repository;

import com.stackroute.paymentservice.model.OrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderResponse,String> {

    List<OrderResponse> findByEmailId(String emailId);
}
