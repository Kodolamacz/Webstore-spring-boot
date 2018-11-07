package com.bs.boot.webstore.rest;

import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blazej on 30.10.2018.
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser")
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

}
