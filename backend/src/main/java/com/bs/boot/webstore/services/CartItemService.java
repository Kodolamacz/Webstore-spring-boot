package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.CartItem;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface CartItemService {

    Optional<CartItem> findById(Long id);
    CartItem save(CartItem cartItem);
    void deleteById(Long id);
    List<CartItem> findByCartId(Long id);
}
