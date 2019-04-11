package com.lanu.the_yard.security;

import com.lanu.the_yard.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user){
        if (existByUsername(user.getUsername())){
            throw new UserAlreadyExistsException("User " + user.getUsername() + " already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        /*user.setRoles(Arrays.asList(new Role((long) 1, "USER")));*/
        user.setActive(true);
        User theUser = userRepository.save(user);

        return theUser;
    }

    @Override
    public boolean checkPassword(String pass, User user) {
        return passwordEncoder.matches(pass, user.getPassword());
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
