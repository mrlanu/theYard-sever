package com.lanu.the_yard.repositories;

import com.lanu.the_yard.entities.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrailerRepository extends JpaRepository<Trailer, Long> {

    List<Trailer> findAllByCompanyId(Long companyId);
}
