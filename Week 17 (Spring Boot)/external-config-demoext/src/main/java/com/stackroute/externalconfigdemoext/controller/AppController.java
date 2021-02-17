package com.stackroute.externalconfigdemoext.controller;

import com.stackroute.externalconfigdemoext.model.AppDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppController {
//
//    @Value("${app.title}")
//    private String appTitle;
//    @Autowired
//    private Environment env;
//
//    @GetMapping("/property")
//    public String getPropertyValue() {
//        String keyValue = env.getProperty("app.title");
//        return keyValue;
//    }

//    @GetMapping("/value")
//    public String getValue() {
//        return appTitle;
//    }
    @Autowired
    AppDemo appDemo;
    @GetMapping("/title")
    public String getAppTitle() {
        return appDemo.getTitle();
    }
    @GetMapping("/description")
    public String getAppDescription() {
        return appDemo.getDescription();
    }
}
