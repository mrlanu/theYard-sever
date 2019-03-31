package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.services.BreakingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BreakingReportController {

    @Autowired
    private BreakingReportService breakingReportService;

    @PostMapping("/breaking")
    public BreakingReport createBreakingReport(@Valid @RequestBody BreakingReport breakingReport){
        return breakingReportService.createBreakingReport(breakingReport);
    }

    @GetMapping("trailers/{trailerId}/breakings")
    public List<BreakingReport> getAllByTrailerId(@PathVariable(value = "trailerId") Long trailerId){
        return breakingReportService.findAllByTrailerId(trailerId);
    }

    @GetMapping("/breakings/{breakingId}")
    public BreakingReport getBreakingById(@PathVariable(value = "breakingId") Long breakingId){
        return breakingReportService.findById(breakingId);
    }
}
