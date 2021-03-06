package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.dto.CategoryDTO;
import com.bs.boot.webstore.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/category")

public class CategoryController {

    private CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/getCategoryById/{id}")
    public Category getById(@PathVariable("id") Long id ){

        return categoryService.findById(id).get();
    }

    @GetMapping(value = "/getCategoryByName/{name}")
    public Category getByName(@PathVariable("name") String name ){

        return categoryService.findByName(name).get();
    }

    @PostMapping(value = "/addCategory")
    public void addCategory(@RequestBody String categoryStr) throws IOException {
        System.out.println("KAtegoria: " + categoryStr);
        ObjectMapper mapper = new ObjectMapper();
        Category category = mapper.readValue(categoryStr, Category.class);
        categoryService.save(category);
    }

    @GetMapping(value = "/getAll")
    public List<CategoryDTO> getAll( ){

        return categoryService.findAll();
    }



}
