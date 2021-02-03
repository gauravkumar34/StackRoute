package com.stackroute.springbootprojectdemo.services;

import com.stackroute.springbootprojectdemo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();

}
