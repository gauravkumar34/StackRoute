package com.stackroute.jwtauthenticationservice.service;

import com.stackroute.jwtauthenticationservice.exception.UserNotFoundException;
import com.stackroute.jwtauthenticationservice.model.User;
import com.stackroute.jwtauthenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User findByIdAndPassword(String id, String password) throws UserNotFoundException {
        User authUser = userRepository.findByIdAndPassword(id,password);
        if(authUser == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return authUser;
    }
}
