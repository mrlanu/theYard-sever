package com.lanu.the_yard.security;

import com.lanu.the_yard.entities.Trailer;

import java.util.Optional;

public interface UserService {

    User createUser(User user);

    boolean existByUsername(String username);

    Optional<User> findByUserId(Long id);

    Optional<User> findByUsername(String userName);

    User saveUser(User user);

    Trailer getCurrentTrailer(String userName);
}
