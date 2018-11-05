package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.domain.Product;
import com.bs.boot.webstore.services.CategoryService;
import com.bs.boot.webstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping(value = "/getByCategory/{categoryId}")
    public List<Product> getByCategory(@PathVariable("categoryId") Long catId){

        Category category = categoryService.findById(catId).get();

        return productService.findByCategory(category);
    }

    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody Product product){

        productService.save(product);

    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }
}
