package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.domain.Role;
import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.repository.RoleRepository;
import com.bs.boot.webstore.repository.UserRepository;
import com.bs.boot.webstore.services.UserService;
import io.netty.util.internal.SocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Blazej on 30.10.2018.
 */
@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {

        Role role = roleRepository.findByName("USER").get();
        user.addRole(role);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (user.getCart() == null) user.setCart(new Cart());
        System.out.println(user.toString());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRoles(role);
    }
}
