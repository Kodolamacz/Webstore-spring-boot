package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.Role;
import com.bs.boot.webstore.repository.RoleRepository;
import com.bs.boot.webstore.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
