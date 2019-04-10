package com.lanu.the_yard.security;

import java.util.Optional;

public interface UserService {

    User createUser(User user);

    boolean existByUsername(String username);

    Optional<User> findByUserId(Long id);

    Optional<User> findByUsername(String userName);

    User saveUser(User user);

    boolean checkPassword(String pass, User user);
}
