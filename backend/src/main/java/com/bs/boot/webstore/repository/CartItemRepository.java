package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    Optional<CartItem> findById(Long id);
    CartItem save(CartItem cartItem);
    void deleteById(Long id);
}
