package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.CartItem;
import com.bs.boot.webstore.domain.Product;
import com.bs.boot.webstore.repository.CartItemRepository;
import com.bs.boot.webstore.services.CartItemService;
import com.bs.boot.webstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
@Service
public class CartItemServiceImpl implements CartItemService{

    private CartItemRepository cartItemRepository;
    private ProductService productService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    @Override
    public CartItem save(CartItem cartItem) {

        Product product2Update = productService.findById(cartItem.getProduct().getId()).get();
        product2Update.setUnitsInStock(product2Update.getUnitsInStock() - cartItem.getQuantity());
        productService.save(product2Update);

        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }
}
