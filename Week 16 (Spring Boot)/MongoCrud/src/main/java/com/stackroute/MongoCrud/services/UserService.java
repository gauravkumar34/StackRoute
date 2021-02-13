package com.stackroute.MongoCrud.services;

import com.stackroute.MongoCrud.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User deleteUser(int id);

    User updateUser(User user);

}
