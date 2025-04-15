package com.myproject.repository;

import com.myproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed.
    // Example:
    // Optional<User> findByUsername(String username);
}
// This repository interface extends JpaRepository, which provides CRUD operations for the User entity.
// You can add custom query methods if needed, such as finding users by username or email.