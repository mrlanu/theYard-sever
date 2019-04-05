package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.Log;
import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.repositories.LogRepository;
import com.lanu.the_yard.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log newLog(Log.LogAction logAction, Trailer trailer, User user) {
            return logRepository.save(new Log(null, LocalDateTime.now(),
                    trailer.getLocation(), logAction,
                    trailer.getId(), user.getLastName()));
    }
}
