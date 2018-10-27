package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
    Product save(Product role);
    void deleteById(Long id);

    List<Product> findByCategory(Category category);
}
