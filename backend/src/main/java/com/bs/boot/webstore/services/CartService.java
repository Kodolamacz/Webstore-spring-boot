package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.domain.User;

import java.util.Optional;

/**
 * Created by Blazej on 01.11.2018.
 */
public interface CartService {

    Optional<Cart> findById(Long id);
    Optional<Cart> findByOwner(User user);

}
