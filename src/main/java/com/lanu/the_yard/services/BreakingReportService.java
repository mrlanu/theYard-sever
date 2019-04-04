package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.security.User;

import java.util.List;

public interface BreakingReportService {
    BreakingReport saveBreakingReport(BreakingReport breakingReport);
    BreakingReport createBreakingReport(BreakingReport breakingReport, User user);
    List<BreakingReport> findAllByTrailerId(Long trailerId);
    BreakingReport findById(Long id);
    BreakingReport fixBreakingDetail(Long breakingReportId, Long breakingDetailId, User user);
}
