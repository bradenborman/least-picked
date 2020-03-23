package com.borman.leastpicked.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/test")
    public String test() {
        return "Up and Running";
    }

}