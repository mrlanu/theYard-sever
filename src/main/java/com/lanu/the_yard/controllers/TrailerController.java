package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.services.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @GetMapping
    public List<Trailer> findAllByCompanyId(@RequestParam(name = "companyId") Long companyId){
        return trailerService.findAllByCompanyId(companyId);
    }
}
