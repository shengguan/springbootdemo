package com.gb.springbootdemo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HelloController {
    @GetMapping("/hello/{id}")
    public String hello(@PathVariable Integer id) {
        return "ID = " + id;
    }


}
