package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.repositories.BreakingDetailRepository;
import com.lanu.the_yard.repositories.BreakingReportRepository;
import com.lanu.the_yard.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreakingReportServiceImpl implements BreakingReportService {

    @Autowired
    private BreakingReportRepository breakingReportRepository;

    @Autowired
    private TrailerService trailerService;

    @Override
    public BreakingReport createBreakingReport(BreakingReport breakingReport, User user) {
        breakingReport.setUserLastName(user.getLastName());
        Trailer trailer = trailerService.findTrailerById(breakingReport.getTrailerId());
        trailer.setBroken(true);
        trailerService.save(trailer);
        return breakingReportRepository.save(breakingReport);
    }

    @Override
    public List<BreakingReport> findAllByTrailerId(Long trailerId) {
        return breakingReportRepository.findAllByTrailerId(trailerId);
    }

    @Override
    public BreakingReport findById(Long id) {
        return breakingReportRepository.findById(id).get();
    }
}
