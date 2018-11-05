package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.services.CartItemService;
import com.bs.boot.webstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/cart")
public class CartController {


    private CartItemService cartItemService;
    private CartService cartService;

    @Autowired
    public CartController(CartItemService cartItemService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }

    @GetMapping(value = "/getCart/{id}")
    public Cart getCartById(@PathVariable("id") Long id){

        return cartService.findById(id).get();
    }
}
