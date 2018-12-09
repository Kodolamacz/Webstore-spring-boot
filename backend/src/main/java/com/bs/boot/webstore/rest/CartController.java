package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.domain.CartItem;
import com.bs.boot.webstore.domain.Product;
import com.bs.boot.webstore.services.CartItemService;
import com.bs.boot.webstore.services.CartService;
import com.bs.boot.webstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    private ProductService productService;
    private CartService cartService;


    @Autowired
    public CartController(CartItemService cartItemService, ProductService productService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping(value = "/getCart/{id}")
    public Cart getCartById(@PathVariable("id") Long id){

        return cartService.findById(id).get();
    }

    @PostMapping(value = "/createCartItem")
    public CartItem createCartItem(@RequestBody CartItem newCartItem ){

        return cartItemService.save(newCartItem);

    }

    @GetMapping(value = "/summaryCart/{id}")
    public Cart summaryCart(@PathVariable("id") Long id){
        Cart cart = cartService.findById(id).get();
        cart.calculateTotalCost();
        return cart;
    }

    @GetMapping(value = "/getCartItems/{cartId}")
    public List<CartItem> getCartItems(@PathVariable("cartId") Long cartId){

        return cartItemService.findByCartId(cartId);
    }

}
