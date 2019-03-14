package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.repositories.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerServiceImpl implements TrailerService {

    @Autowired
    private TrailerRepository trailerRepository;

    @Override
    public List<Trailer> findAllByCompanyId(Long companyId) {
        return trailerRepository.findAllByCompanyId(companyId);
    }
}
