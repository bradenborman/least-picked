package com.borman.leastpicked.controllers;

import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.GameOption;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.services.SelectionService;
import com.borman.leastpicked.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SelectionService selectionService;


    @Autowired
    UserService userService;


    @GetMapping("/app-data")
    public ResponseEntity<AppData> getAppData(@AuthenticationPrincipal OAuth2User principal) throws InterruptedException {
        Thread.sleep(750);
        AppData appData = new AppData();
        appData.setUserName(principal.getAttribute("name"));
        appData.setUserEmail(principal.getAttribute("email"));
        appData.setUsersFirstTime(userService.insertUserIfNessary(appData.getUserEmail()));
        appData.setUserScore(new Random().nextInt(35));

        getGameOptions(appData);

        return ResponseEntity.ok(appData);
    }

    @PostMapping("/updateSelected")
    public ResponseEntity<String> submitPick(@AuthenticationPrincipal OAuth2User principal, @RequestBody UpdateSelectionRequest updateSelectionRequest) {
        return selectionService.updateSelection(updateSelectionRequest);
    }

    private void getGameOptions(AppData appData) {
        GameOption gameOption1 = new GameOption(1, "Option 1", false);
        GameOption gameOption2 = new GameOption(2, "Option 2", false);
        GameOption gameOption3 = new GameOption(3, "Option 3", false);

        String picked = selectionService.getUsersSelectionToday(appData.getUserEmail());
        List<GameOption> gameOptionsList = Arrays.asList(gameOption1, gameOption2, gameOption3);
        if(picked != null) {
            gameOptionsList.forEach(gameOption -> {
                if(String.valueOf(gameOption.getId()).equals(picked))
                    gameOption.setSelected(true);
                    appData.setActiveOption(gameOption.getId());
            });
        }

        appData.setOptions(gameOptionsList);

    }

}