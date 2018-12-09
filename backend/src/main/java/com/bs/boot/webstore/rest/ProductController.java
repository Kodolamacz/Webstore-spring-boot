package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.Category;
import com.bs.boot.webstore.domain.Product;
import com.bs.boot.webstore.dto.ProductDTO;
import com.bs.boot.webstore.services.CategoryService;
import com.bs.boot.webstore.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Value("${file.upload-dir}")
    private String uploadDir;

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
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<ProductDTO> getAllProducts(){
        return productService.getProductsToDisplay();
    }



    @GetMapping(value = "/getByCategory/{categoryId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getByCategory(@PathVariable("categoryId") Long catId){

        Category category = categoryService.findById(catId).get();

        return productService.findByCategory(category);
    }

    @PostMapping(value = "/addProduct", headers = "Accept=application/json", consumes = {"multipart/form-data"})
    public Product addProduct(@RequestPart("product") String product, @RequestPart("image") MultipartFile[] files,
                              @RequestPart("category") String categoryJson){

        ObjectMapper mapper = new ObjectMapper();
        Product savedProduct = new Product();
        Category category = new Category();// = mapper.readValue(categoryJson, Category.class);
        try {
            savedProduct = productService.save(mapper.readValue(product, Product.class));
            category = mapper.readValue(categoryJson, Category.class);
            category = categoryService.findById(category.getId()).get();

            System.out.println("TEST " + savedProduct);
            System.out.println("TEST cat json " + categoryJson);
            System.out.println("TEST cat " + category);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(savedProduct.toString());
        String uploadPath = uploadDir + "/" + savedProduct.getId() + "_" + savedProduct.getName();
        new File(uploadPath).mkdirs();

        StringBuilder imgPaths = new StringBuilder();
        for (MultipartFile multipartFile : files){

            System.out.println(multipartFile.getOriginalFilename());

            Path pathAndFilename = Paths.get(uploadPath, multipartFile.getOriginalFilename());
            imgPaths.append(pathAndFilename.toString().replace("../frontend/src/",""));
            imgPaths.append(",");

            try {
                Files.write(pathAndFilename, multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        savedProduct.setImagePaths(imgPaths.toString());

//        Category category = categoryService.findByName(product.getCategory().getName()).orElse(new Category());
//        if(category.getName() == null) {
//            category.setName(product.getCategory().getName());
//        }

        category.addProduct(savedProduct);
        categoryService.save(category);

        savedProduct.setCategory(category);
        return productService.save(savedProduct);


    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }
}
