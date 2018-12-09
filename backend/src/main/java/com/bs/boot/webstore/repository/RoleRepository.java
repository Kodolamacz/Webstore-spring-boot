package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{

    Optional<Role> findById(Long id);
    Optional<Role> findByName(String name);
    List<Role> findByUsers_Username(String username);
    List<Role> findAll();
    Role save(Role role);
    void deleteById(Long id);
}
