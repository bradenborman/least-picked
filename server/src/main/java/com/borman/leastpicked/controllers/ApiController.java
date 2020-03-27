package com.borman.leastpicked.controllers;

import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.services.SelectionService;
import com.borman.leastpicked.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SelectionService selectionService;


    @Autowired
    UserService userService;


    @GetMapping("/app-data")
    public ResponseEntity<AppData> getAppData(@AuthenticationPrincipal OAuth2User principal) {
        AppData appData = new AppData();

        //done for now
        appData.setUserName(principal.getAttribute("name"));
        appData.setUserEmail(principal.getAttribute("email"));
        appData.setUsersFirstTime(userService.insertUserIfNessary(appData.getUserEmail()));

        appData.setUserScore(new Random().nextInt(10)); //todo
        appData.setHighScore(appData.getUserScore() + 6); //todo
        appData.setActiveSeason("Season 1");
        appData.setDaysUntilNextSeason(15);

        selectionService.configGameOptions(appData);

        return ResponseEntity.ok(appData);
    }

    @PostMapping("/updateSelected")
    public ResponseEntity<String> submitPick(@AuthenticationPrincipal OAuth2User principal, @RequestBody UpdateSelectionRequest updateSelectionRequest) {
        return selectionService.updateSelection(updateSelectionRequest);
    }


}