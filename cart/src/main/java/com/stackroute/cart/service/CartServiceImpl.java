package com.stackroute.cart.service;

import com.stackroute.cart.exception.CartIdNotFoundException;
import com.stackroute.cart.exception.EmailIdNotFoundException;
import com.stackroute.cart.model.Cart;
import com.stackroute.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addToCart(Cart cart){
    return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartByEmailId(String emailId) throws EmailIdNotFoundException {
        if(!cartRepository.getCartByEmailId(emailId).isEmpty()){
            return cartRepository.getCartByEmailId(emailId);
        }
        else{
            throw new EmailIdNotFoundException();
        }
    }
    @Override
    public String deleteById(int cartId) throws CartIdNotFoundException{
        if(cartRepository.findById(cartId).isPresent()){
            cartRepository.deleteById(cartId);
            return "Service removed from cart";
        }else {
            throw new CartIdNotFoundException();
        }
    }

    @Override
    public String deleteAllByEmailId(String emailId){
        cartRepository.deleteByEmailId(emailId);
        return "Cart Deleted";
    }
}
