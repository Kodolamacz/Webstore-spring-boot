package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.repository.CartRepository;
import com.bs.boot.webstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Blazej on 01.11.2018.
 */
@Service
public class CartServiceImpl  implements CartService{

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Optional<Cart> findByOwner(User user) {
        return null;
    }
}
