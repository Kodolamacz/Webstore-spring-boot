package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.Category;

import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface CategoryService {

    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Category save(Category category);
    void deleteById(Long id);
}
