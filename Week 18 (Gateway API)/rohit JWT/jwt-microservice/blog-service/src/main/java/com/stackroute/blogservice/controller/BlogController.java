package com.stackroute.blogservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @GetMapping("data")
    public String getSensitiveData(){
        return "Welcome to blog page!";
    }

}
