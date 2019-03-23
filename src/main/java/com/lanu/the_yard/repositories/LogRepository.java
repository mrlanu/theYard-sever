package com.lanu.the_yard.repositories;

import com.lanu.the_yard.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAllByTrailerId(Long trailerId);
}
