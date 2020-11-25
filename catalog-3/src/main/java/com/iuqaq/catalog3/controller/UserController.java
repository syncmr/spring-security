package com.iuqaq.catalog3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello user hello()";
    }

}