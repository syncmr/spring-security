package com.iuqaq.catalog3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("/hello")
    public String hello() {
        return "hello admin hello()";
    }

}