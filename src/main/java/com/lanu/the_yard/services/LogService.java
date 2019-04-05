package com.lanu.the_yard.services;

import com.lanu.the_yard.entities.Log;
import com.lanu.the_yard.entities.Trailer;
import com.lanu.the_yard.security.User;

public interface LogService {
    Log newLog(Log.LogAction logAction, Trailer trailer, User user);
}
