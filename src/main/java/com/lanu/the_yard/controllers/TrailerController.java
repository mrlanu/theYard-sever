package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.Log;
import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.repositories.LogRepository;
import com.lanu.the_yard.security.User;
import com.lanu.the_yard.security.UserService;
import com.lanu.the_yard.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogRepository logRepository;

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
        return trailerService.findTrailerByUserId(theUser.getUserId());
    }

    @GetMapping("/pickup")
    public ResponseEntity<?> pickUpTrailer(Principal principal, @RequestParam(name = "trailerId") Long trailerId){
        User theUser = userService.findByUsername(principal.getName()).get();

        Trailer theTrailer = trailerService.findTrailerById(trailerId);
        theTrailer.setAvailable(false);
        theTrailer.setUser(theUser);
        theTrailer = trailerService.save(theTrailer);

        newLog(Log.LogAction.PICKUP, theTrailer, theUser);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/drop")
    public Trailer dropCurrentTrailer(Principal principal, @Valid @RequestBody Trailer trailer){
        User theUser = userService.findByUsername(principal.getName()).get();

        newLog(Log.LogAction.DROP, trailer, theUser);

        return trailerService.save(trailer);
    }

    private Log newLog(Log.LogAction logAction, Trailer trailer, User user){
        return logRepository.save(new Log(null, LocalDateTime.now(),
                        trailer.getLocation(), logAction,
                        trailer, user.getLastName()));
    }
}
