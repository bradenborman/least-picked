package com.borman.leastpicked.controllers;

import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.modls.responses.LeaderBoardResponse;
import com.borman.leastpicked.services.AppDataService;
import com.borman.leastpicked.services.LeaderBoardService;
import com.borman.leastpicked.services.SelectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private SelectionService selectionService;
    private LeaderBoardService leaderboardService;
    private AppDataService appDataService;

    public ApiController(SelectionService selectionService, LeaderBoardService leaderboardService, AppDataService appDataService) {
        this.selectionService = selectionService;
        this.leaderboardService = leaderboardService;
        this.appDataService = appDataService;
    }

    @GetMapping("/app-data")
    public ResponseEntity<AppData> getAppData(@AuthenticationPrincipal OAuth2User principal) {
       return appDataService.getAppData(principal, new AppData());
    }

    @PostMapping("/updateSelected")
    public ResponseEntity<String> submitPick(@AuthenticationPrincipal OAuth2User principal, @RequestBody UpdateSelectionRequest updateSelectionRequest) {
        return selectionService.updateSelection(updateSelectionRequest);
    }


    @GetMapping("/leaders")
    public ResponseEntity<LeaderBoardResponse> submitPick() {
        return ResponseEntity.ok(leaderboardService.getLeaderBoard());
    }

}