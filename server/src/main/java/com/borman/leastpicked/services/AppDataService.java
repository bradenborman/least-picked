package com.borman.leastpicked.services;

import com.borman.leastpicked.config.GameSettings;
import com.borman.leastpicked.modls.AppData;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AppDataService {

    private SelectionService selectionService;
    private UserService userService;
    private GameSettings gameSettings;

    public AppDataService(SelectionService selectionService, UserService userService, GameSettings gameSettings) {
        this.selectionService = selectionService;
        this.userService = userService;
        this.gameSettings = gameSettings;
    }

    public ResponseEntity<AppData> getAppData(OAuth2User principal, AppData appData) {
        appData.setUserName(principal.getAttribute("name"));
        appData.setUserEmail(principal.getAttribute("email"));
        appData.setUsersFirstTime(userService.insertUserIfNecessary(appData.getUserEmail(), appData.getUserName()));
        appData.setActiveSeason(gameSettings.getActiveSeason().getNickName());
        appData.setDaysLeftInCurrentSeason(gameSettings.getDaysLeftInCurrentSeason());
        userService.setUsersScore(appData, gameSettings.getActiveSeasonInt());
        selectionService.configGameOptions(appData);
        return ResponseEntity.ok(appData);
    }

}