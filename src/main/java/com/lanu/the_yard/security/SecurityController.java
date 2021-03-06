package com.lanu.the_yard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private UserService userService;

    @PostMapping("/checkPass")
    public boolean checkPassword(@RequestBody String pass, Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return userService.checkPassword(pass, user);
    }

    @PostMapping("/signup")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public User getLoggedInUser(Principal principal){
        return userService.findByUsername(principal.getName()).get();
    }
}
