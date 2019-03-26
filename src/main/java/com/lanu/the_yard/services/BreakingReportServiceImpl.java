package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.repositories.BreakingDetailRepository;
import com.lanu.the_yard.repositories.BreakingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreakingReportServiceImpl implements BreakingReportService {

    @Autowired
    private BreakingDetailRepository breakingDetailRepository;

    @Autowired
    private BreakingReportRepository breakingReportRepository;

    @Override
    public BreakingReport createBreakingReport(BreakingReport breakingReport) {
        return breakingReportRepository.save(breakingReport);
    }
}
