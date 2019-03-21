package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.security.User;
import com.lanu.the_yard.security.UserRepository;
import com.lanu.the_yard.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    @GetMapping
    public List<Trailer> findAllByCompanyId(@RequestParam(name = "companyId") Long companyId){
        return trailerService.findAllByCompanyId(companyId);
    }

    @PostMapping
    public Trailer newTrailer(@Valid @RequestBody Trailer trailer, Principal principal){
        User theUser = userRepository.findByUsername(principal.getName()).get();
        return trailerService.createNewTrailer(trailer, theUser);
    }
}