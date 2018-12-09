package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.Role;
import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.repository.RoleRepository;
import com.bs.boot.webstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Blazej on 08.12.2018.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).get();

        if (user == null){
            throw new UsernameNotFoundException(s);
        }
        List<Role> roles =  roleRepository.findByUsers_Username(user.getUsername());
        Set<GrantedAuthority> simpleAuthorities = new HashSet<>();

        roles.stream().forEach(role -> {
            simpleAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        });


        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), simpleAuthorities);

    }
}
