package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.security.User;

import java.util.List;

public interface TrailerService {

    Trailer findTrailerById(Long id);
    List<Trailer> findAllByCompanyId(Long companyId);
    Trailer createNewTrailer(Trailer trailer, User user);
    Trailer save(Trailer trailer);
}
