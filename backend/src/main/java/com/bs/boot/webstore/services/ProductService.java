package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.domain.Product;
import com.bs.boot.webstore.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface ProductService {

    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long id);
    List<ProductDTO> getProductsToDisplay();

    List<Product> findByCategory(Category category);
}
