package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.dto.CategoryDTO;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Category save(Category category);
    void deleteById(Long id);

    @Query("SELECT new com.bs.boot.webstore.dto.CategoryDTO(c.id, c.name) FROM Category c")
    List<CategoryDTO> getAllCategories();
}
