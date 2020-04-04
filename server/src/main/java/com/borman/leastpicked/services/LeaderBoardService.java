package com.borman.leastpicked.services;

import com.borman.leastpicked.config.GameSettings;
import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.builders.LeaderBoardResponseBuilder;
import com.borman.leastpicked.modls.responses.LeaderBoardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardService {

    private SelectionDao selectionDao;
    private GameSettings gameSettings;

    public LeaderBoardService(SelectionDao selectionDao, GameSettings gameSettings) {
        this.selectionDao = selectionDao;
        this.gameSettings = gameSettings;
    }

    public ResponseEntity<LeaderBoardResponse> getLeaderBoard() {

        return ResponseEntity.ok(LeaderBoardResponseBuilder
                .aLeaderBoardResponse()
                .withActiveSeason(
                        gameSettings.getActiveSeason()
                )
                .withDaysLeftInActiveSeason(
                        gameSettings.getDaysLeftInCurrentSeason()
                )
                .withTopTenLeaders(
                        selectionDao.getTopTenLeadersThisSeason(gameSettings.getActiveSeasonInt())
                )
                .build());
    }

}