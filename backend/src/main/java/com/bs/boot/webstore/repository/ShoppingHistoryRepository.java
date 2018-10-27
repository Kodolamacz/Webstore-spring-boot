package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.ShoppingHistory;
import com.bs.boot.webstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface ShoppingHistoryRepository  extends JpaRepository<ShoppingHistory, Long>{

    Optional<ShoppingHistory> findById(Long id);
    Optional<ShoppingHistory> findByOwner(User owner);
    ShoppingHistory save(ShoppingHistory shoppingHistory);
    void deleteById(Long id);
}
