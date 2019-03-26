package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.services.BreakingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/breaking")
public class BreakingReportController {

    @Autowired
    private BreakingReportService breakingReportService;

    @PostMapping
    public BreakingReport createBreakingReport(@Valid @RequestBody BreakingReport breakingReport){
        return breakingReportService.createBreakingReport(breakingReport);
    }
}
