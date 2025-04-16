package com.myproject.repository;

import com.myproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Simple query methods
    List<User> findByUsername(String username);

    List<User> findByEmail(String email);

    // Add your custom query methods here
}
