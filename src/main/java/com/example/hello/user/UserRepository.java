package com.example.hello.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring builds the SQL from the method name: SELECT ... WHERE email = ?
    boolean existsByEmail(String email);
}