package com.bs.boot.webstore.services;

import com.bs.boot.webstore.domain.Role;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
public interface RoleService {

    Optional<Role> findById(Long id);
    Optional<Role> findByName(String name);
    List<Role> findAll();
    Role save(Role role);
    void deleteById(Long id);
}
