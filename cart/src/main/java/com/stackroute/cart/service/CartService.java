package com.stackroute.cart.service;

import com.stackroute.cart.exception.CartIdNotFoundException;
import com.stackroute.cart.exception.EmailIdNotFoundException;
import com.stackroute.cart.model.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(Cart cart);
    List<Cart> getCartByEmailId(String emailId) throws EmailIdNotFoundException;

    String deleteById(int cartId) throws CartIdNotFoundException;

    String deleteAllByEmailId(String emailId);
}
