package com.stackroute.MongoCrud.controller;

import com.stackroute.MongoCrud.model.User;
import com.stackroute.MongoCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){this.userService = userService;}

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User saveUser = userService.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity((List<User>) userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User findUser = userService.getUserById(id);
        return new ResponseEntity<>(findUser,HttpStatus.FOUND);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id){
        User deletedUser = userService.getUserById(id);
        userService.deleteUser(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return  new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
}
