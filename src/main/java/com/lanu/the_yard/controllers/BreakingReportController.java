package com.lanu.the_yard.controllers;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.entities.Log;
import com.lanu.the_yard.repositories.LogRepository;
import com.lanu.the_yard.security.User;
import com.lanu.the_yard.security.UserService;
import com.lanu.the_yard.services.BreakingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BreakingReportController {

    @Autowired
    private BreakingReportService breakingReportService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/breaking")
    public BreakingReport createBreakingReport(@Valid @RequestBody BreakingReport breakingReport,
                                               Principal principal){
        User theUser = userService.findByUsername(principal.getName()).get();
        newLog(Log.LogAction.BREAKING, breakingReport.getTrailerId(), theUser);
        return breakingReportService.createBreakingReport(breakingReport, theUser);
    }

    @GetMapping("trailers/{trailerId}/breakings")
    public List<BreakingReport> getAllByTrailerId(@PathVariable(value = "trailerId") Long trailerId){
        return breakingReportService.findAllByTrailerId(trailerId);
    }

    @GetMapping("/breakings/{breakingId}")
    public BreakingReport getBreakingById(@PathVariable(value = "breakingId") Long breakingId){
        return breakingReportService.findById(breakingId);
    }

    @GetMapping("breaking/fixBreakingDetail/{breakingReportId}/{breakingDetailId}")
    public BreakingReport fixBreakingDetail(@PathVariable(value = "breakingReportId") Long breakingReportId,
                                            @PathVariable(value = "breakingDetailId") Long breakingDetailId,
                                            Principal principal){
        User theUser = userService.findByUsername(principal.getName()).get();
        BreakingReport breakingReport = breakingReportService.findById(breakingReportId);
        newLog(Log.LogAction.FIXED, breakingReport.getTrailerId(), theUser);
        return breakingReportService.fixBreakingDetail(breakingReportId, breakingDetailId, theUser);
    }

    private Log newLog(Log.LogAction logAction, Long trailerId, User user){
        return logRepository.save(new Log(null, LocalDateTime.now(),
                null, logAction,
                trailerId, user.getLastName()));
    }
}
