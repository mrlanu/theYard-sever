package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.Trailer;

import java.util.List;

public interface TrailerService {

    List<Trailer> findAllByCompanyId(Long companyId);
}
