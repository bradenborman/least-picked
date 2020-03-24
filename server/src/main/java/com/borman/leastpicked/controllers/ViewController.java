package com.borman.leastpicked.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ViewController {

    @GetMapping({
            "/",
            "/rules",
            "/leaderboard",
            "/play",
            "rules",
            "leaderboard",
            "play"
    })
    public String getView() {
        return "index";
    }

}