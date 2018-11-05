package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.Role;
import com.bs.boot.webstore.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface UserService {

    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    void deleteById(Long id);
    List<User> findAll();
    List<User> findByRole(Role role);
}
