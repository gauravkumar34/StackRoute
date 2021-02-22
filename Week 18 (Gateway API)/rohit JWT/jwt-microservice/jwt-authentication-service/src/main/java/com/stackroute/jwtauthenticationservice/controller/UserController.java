package com.stackroute.jwtauthenticationservice.controller;

import com.stackroute.jwtauthenticationservice.config.JWTTokenGenerator;
import com.stackroute.jwtauthenticationservice.exception.UserNotFoundException;
import com.stackroute.jwtauthenticationservice.model.User;
import com.stackroute.jwtauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    private JWTTokenGenerator jwtTokenGenerator;
    ResponseEntity<?> responseEntity;

    @Value("${app.controller.exception.message1}")
    private String message1;

    @Value("${app.controller.exception.message2}")
    private String message2;

    @Value("${app.controller.exception.message3}")
    private String message3;

    @Autowired
    public UserController(UserService userService, JWTTokenGenerator jwtTokenGenerator) {
        this.userService = userService;
        this.jwtTokenGenerator=jwtTokenGenerator;
    }

    @PostMapping("/login/user")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try {
            if (user.getId() == null || user.getPassword() == null) {
                throw new UserNotFoundException(message1);
            }

            User userDetails = userService.findByIdAndPassword(user.getId(), user.getPassword());
            if (userDetails == null) {
                throw new UserNotFoundException(message2);
            }
            if (!user.getPassword().equals(userDetails.getPassword())) {
                throw new UserNotFoundException(message3);
            }
            responseEntity = new ResponseEntity<>(jwtTokenGenerator.generateToken(userDetails), HttpStatus.OK);
        }catch (UserNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}