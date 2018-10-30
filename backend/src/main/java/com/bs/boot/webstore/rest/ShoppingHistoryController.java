package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.services.ShoppingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
public class ShoppingHistoryController {

    private ShoppingHistoryService shoppingHistoryService;

    @Autowired
    public ShoppingHistoryController(ShoppingHistoryService shoppingHistoryService) {
        this.shoppingHistoryService = shoppingHistoryService;
    }
}
