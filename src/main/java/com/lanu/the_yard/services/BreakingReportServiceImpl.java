package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.BreakingReport;
import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.repositories.BreakingReportRepository;
import com.lanu.the_yard.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreakingReportServiceImpl implements BreakingReportService {

    @Autowired
    private BreakingReportRepository breakingReportRepository;

    @Autowired
    private TrailerService trailerService;

    @Override
    public BreakingReport saveBreakingReport(BreakingReport breakingReport) {
        return breakingReportRepository.save(breakingReport);
    }

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

    @Override
    public BreakingReport fixBreakingDetail(Long breakingReportId, Long breakingDetailId, User user) {

        BreakingReport breakingReport = breakingReportRepository.findById(breakingReportId).get();
        breakingReport.getBreakingDetails().forEach(breakingDetail -> {
            if (breakingDetail.getId() == breakingDetailId){
                breakingDetail.setFixed(true);
                breakingDetail.setFixedDate(LocalDateTime.now());
                breakingDetail.setFixedByUserLastName(user.getLastName());
            }
        });

        // if all BreakingDetail is fixed set BreakingReport is fixed
        boolean allBreakingDetailsFixed = breakingReport.getBreakingDetails()
                .stream()
                .filter(bD -> !bD.isFixed())
                .collect(Collectors.toList()).isEmpty();

        if (allBreakingDetailsFixed){
            breakingReport.setFixed(true);
            breakingReport.setFixedDate(LocalDateTime.now());
            breakingReport.setUserLastName(user.getLastName());
        }

        //if all BreakingReport is fixed set the Trailer is not broken
        boolean allBreakingReportFixed = findAllByTrailerId(breakingReport.getTrailerId())
                .stream()
                .filter(bR -> !bR.isFixed())
                .collect(Collectors.toList()).isEmpty();

        if (allBreakingReportFixed){
            Trailer trailer = trailerService.findTrailerById(breakingReport.getTrailerId());
            trailer.setBroken(false);
            trailerService.save(trailer);
        }

        return breakingReportRepository.save(breakingReport);
    }
}
