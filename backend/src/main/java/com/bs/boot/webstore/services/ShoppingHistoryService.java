package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.ShoppingHistory;
import com.bs.boot.webstore.domain.User;

import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface ShoppingHistoryService {

    Optional<ShoppingHistory> findById(Long id);
    Optional<ShoppingHistory> findByOwner(User owner);
    ShoppingHistory save(ShoppingHistory shoppingHistory);
    void deleteById(Long id);
}
