package com.borman.leastpicked.controllers;

import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.GameOption;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping("/user")
    public ResponseEntity<AppData> getAppData(@AuthenticationPrincipal OAuth2User principal) throws InterruptedException {
        Thread.sleep(1500);
        AppData appData = new AppData();
        appData.setUserEmail(principal.getAttribute("name"));
        appData.setOptions(getGameOptions());
        return ResponseEntity.ok(appData);
    }

    @PostMapping("/submit-option")
    public ResponseEntity<String> submitPick(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok("");
    }


    private List<GameOption> getGameOptions() {
        GameOption gameOption1 = new GameOption(1, "Door 1", false);
        GameOption gameOption2 = new GameOption(2, "Door 2", true);
        GameOption gameOption3 = new GameOption(3, "Door 3", false);
        return Arrays.asList(gameOption1, gameOption2, gameOption3);
    }

}