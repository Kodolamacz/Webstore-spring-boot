package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/cart")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
}
