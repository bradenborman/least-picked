package com.borman.leastpicked.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    @GetMapping("/user")
    public ResponseEntity<String> test(@AuthenticationPrincipal OAuth2User principal) {
        String name = principal.getAttribute("name");
        System.out.println("Player Logged in: " + name);
        return ResponseEntity.ok(name);
    }


}