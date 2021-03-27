package com.notebook.userlogin.controller;

import com.notebook.userlogin.config.BcryptGenerator;
import com.notebook.userlogin.config.JWTGenerator;
import com.notebook.userlogin.exception.InvalidCredentials;
import com.notebook.userlogin.model.User;
import com.notebook.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value="*")
@RequestMapping("/api/v1/login")
public class UserController {

    private UserService userService;
    private JWTGenerator jwtGenerator;
    private BcryptGenerator bcryptGenerator;

    @Autowired
    public UserController(UserService userService, JWTGenerator jwtGenerator, BcryptGenerator bcryptGenerator) {
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.bcryptGenerator =bcryptGenerator;
    }

    @PostMapping("/user")
    public ResponseEntity<?> getCredentials(@RequestBody User user) throws InvalidCredentials {
        User userEmailExists = userService.findByEmail(user.getEmail());

        String existingPassword =userEmailExists.getPassword();

        String currentPassword=user.getPassword();

        Boolean t = bcryptGenerator.passwordDecoder(currentPassword,existingPassword);

        if(t){

            return new ResponseEntity<>(jwtGenerator.generatorJwtToken(user), HttpStatus.OK);
        }
        throw new InvalidCredentials();
    }
}
