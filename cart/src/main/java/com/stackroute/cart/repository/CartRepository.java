package com.stackroute.cart.repository;

import com.stackroute.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart,Integer> {
    @Query("{'emailId':{$in:[?0]}}")
    List<Cart> getCartByEmailId(String emailId);

    String deleteByEmailId(String emailId);
}
