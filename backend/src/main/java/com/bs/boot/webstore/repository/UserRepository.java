package com.bs.boot.webstore.repository;

import com.bs.boot.webstore.domain.Role;
import com.bs.boot.webstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.10.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    void deleteById(Long id);
    List<User> findAll();
    List<User> findByRoles(Role role);

}
