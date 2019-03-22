package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.security.User;
import com.lanu.the_yard.security.UserService;
import com.lanu.the_yard.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Trailer> findAllByCompanyId(@RequestParam(name = "companyId") Long companyId){
        return trailerService.findAllByCompanyId(companyId);
    }

    @PostMapping
    public Trailer newTrailer(@Valid @RequestBody Trailer trailer, Principal principal){
        User theUser = userService.findByUsername(principal.getName()).get();
        return trailerService.createNewTrailer(trailer, theUser);
    }

    @GetMapping("/user")
    public Trailer getCurrentTrailer(Principal principal){
        User theUser = userService.findByUsername(principal.getName()).get();
        return theUser.getTrailer();
    }

    @GetMapping("/drop")
    public ResponseEntity<?> dropCurrentTrailer(Principal principal){
        User theUser = userService.findByUsername(principal.getName()).get();
        theUser.setTrailer(null);
        userService.saveUser(theUser);
        return ResponseEntity.ok().build();
    }
}
