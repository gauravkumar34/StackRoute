package com.notebook.userlogin.service;

import com.notebook.userlogin.model.User;
import com.notebook.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmailAndPassword(String email, String password) {
        User foundUser = userRepository.findByEmailAndPassword(email, password);
        return foundUser;
    }

    public User findByEmail(String email) {
        User foundUser = userRepository.findByEmail(email);
        return foundUser;
    }
}
