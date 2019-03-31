package com.lanu.the_yard.repositories;

import com.lanu.the_yard.entities.BreakingReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakingReportRepository extends JpaRepository<BreakingReport, Long> {
    List<BreakingReport> findAllByTrailerId(Long trailerId);
}
