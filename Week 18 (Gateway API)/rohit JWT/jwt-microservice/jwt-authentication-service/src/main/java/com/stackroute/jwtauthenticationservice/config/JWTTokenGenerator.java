package com.stackroute.jwtauthenticationservice.config;

import com.stackroute.jwtauthenticationservice.model.User;

import java.util.Map;

public interface JWTTokenGenerator {
    Map<String,String> generateToken(User user);
}
