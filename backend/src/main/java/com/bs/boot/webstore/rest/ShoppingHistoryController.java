package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.ShoppingHistory;
import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.services.ShoppingHistoryService;
import com.bs.boot.webstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/shoppingHistory")
public class ShoppingHistoryController {

    private ShoppingHistoryService shoppingHistoryService;
    private UserService userService;


    @Autowired
    public ShoppingHistoryController(ShoppingHistoryService shoppingHistoryService, UserService userService) {
        this.shoppingHistoryService = shoppingHistoryService;
        this.userService = userService;
    }

    @GetMapping(value = "/getUserHistory/{userId}")
    public ShoppingHistory getHistory(@PathVariable("userId") Long id){

        User owner = userService.findById(id).get();
        return shoppingHistoryService.findByOwner(owner).get();
    }
}
