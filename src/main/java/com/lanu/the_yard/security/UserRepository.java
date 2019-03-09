package com.lanu.the_yard.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

    Optional<User> findByUserId(Long id);

    boolean existsByUsername(String username);
}
