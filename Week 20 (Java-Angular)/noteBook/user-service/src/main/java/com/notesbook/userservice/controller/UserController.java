package com.notesbook.userservice.controller;
import com.notesbook.userservice.config.BcryptGenerator;
import com.notesbook.userservice.exception.UserAlreadyExist;
import com.notesbook.userservice.model.User;
import com.notesbook.userservice.services.RabbitMqSender;
import com.notesbook.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;
    private BcryptGenerator bcryptGenerator;
    private RabbitMqSender rabbitMqSender;
    @Autowired
    public UserController(UserService userService, BcryptGenerator bcryptGenerator, RabbitMqSender rabbitMqSender) {
        this.userService = userService;
        this.bcryptGenerator = bcryptGenerator;
        this.rabbitMqSender = rabbitMqSender;
    }

    @Value("${app.message}")
    private String message;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUser(), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyExist {

        User userByEmailExist = userService.getUserByEmail(user.getEmail());

        if(userByEmailExist != null){
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
        } else {
        user.setUserId(UUID.randomUUID().toString());
        user.setEmail(user.getEmail());
        user.setName(user.getName());
        String password = bcryptGenerator.passwordEncoder(user.getPassword());
        user.setPassword(password);
        User saveUser = userService.saveUser(user);
        rabbitMqSender.send(saveUser);
            return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
        }
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUserById(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}

