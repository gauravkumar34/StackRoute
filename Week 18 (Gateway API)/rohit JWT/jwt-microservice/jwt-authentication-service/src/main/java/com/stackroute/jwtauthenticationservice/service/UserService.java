package com.stackroute.jwtauthenticationservice.service;

import com.stackroute.jwtauthenticationservice.exception.UserNotFoundException;
import com.stackroute.jwtauthenticationservice.model.User;


public interface UserService {
    User findByIdAndPassword(String id,String password) throws UserNotFoundException;
}
