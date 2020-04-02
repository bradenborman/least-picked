package com.borman.leastpicked.controllers;

import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.LeaderBoardRow;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.services.LeaderBoardService;
import com.borman.leastpicked.services.SelectionService;
import com.borman.leastpicked.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SelectionService selectionService;


    @Autowired
    UserService userService;

    @Autowired
    LeaderBoardService leaderboardService;

    @GetMapping("/app-data")
    public ResponseEntity<AppData> getAppData(@AuthenticationPrincipal OAuth2User principal) {
        AppData appData = new AppData();

        //done for now
        appData.setUserName(principal.getAttribute("name"));
        appData.setUserEmail(principal.getAttribute("email"));
        appData.setUsersFirstTime(userService.insertUserIfNecessary(appData.getUserEmail(), appData.getUserName()));

        String seasonId = "1";

        appData.setActiveSeason("Season " + seasonId);
        appData.setDaysUntilNextSeason(15);

        userService.setUsersScore(appData, seasonId);
        selectionService.configGameOptions(appData);

        appData.setHighScore(appData.getUserScore() + 6); //todo

        return ResponseEntity.ok(appData);
    }

    @PostMapping("/updateSelected")
    public ResponseEntity<String> submitPick(@AuthenticationPrincipal OAuth2User principal, @RequestBody UpdateSelectionRequest updateSelectionRequest) {
        return selectionService.updateSelection(updateSelectionRequest);
    }


    @GetMapping("/leaders")
    public ResponseEntity<List<LeaderBoardRow>> submitPick() {
        return leaderboardService.getLeaderBoard();
    }

}