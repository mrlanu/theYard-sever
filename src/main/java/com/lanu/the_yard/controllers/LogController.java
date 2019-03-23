package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.Log;
import com.lanu.the_yard.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogRepository logRepository;

    @PostMapping
    public Log newLog(@Valid @RequestBody Log log){
        return logRepository.save(log);
    }

    @GetMapping("/{trailerId}")
    public List<Log> getAllByTrailerId(@PathVariable(value = "trailerId") Long trailerId){
        return logRepository.findAllByTrailerId(trailerId);
    }
}
