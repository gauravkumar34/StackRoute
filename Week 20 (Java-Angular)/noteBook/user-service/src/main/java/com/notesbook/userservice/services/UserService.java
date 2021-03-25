package com.notesbook.userservice.services;

import com.notesbook.userservice.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    User getUserByEmail(String email);
}
