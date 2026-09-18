package com.khoivu.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloWorldController {

    // inject properties from application.properties file
    @Value ("${author.name}")
    private String authorName;
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World, Author: " + authorName;
    }

}