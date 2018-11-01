package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Blazej on 01.11.2018.
 */
@Repository
public interface CartRepository  extends JpaRepository<Cart, Long>{

//    Optional<Cart> findById(Long id);
}
