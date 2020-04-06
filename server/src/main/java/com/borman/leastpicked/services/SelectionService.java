package com.borman.leastpicked.services;

import com.borman.leastpicked.config.GameSettings;
import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.GameOption;
import com.borman.leastpicked.modls.User;
import com.borman.leastpicked.modls.database.DetailedPickHistory;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import com.borman.leastpicked.utilities.DateManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SelectionService {

    private Logger logger = LoggerFactory.getLogger(SelectionService.class);

    private SelectionDao selectionDao;
    private GameSettings gameSettings;

    public SelectionService(SelectionDao selectionDao, GameSettings gameSettings) {
        this.selectionDao = selectionDao;
        this.gameSettings = gameSettings;
    }

    public ResponseEntity<String> updateSelection(UpdateSelectionRequest request) {
        logger.info("User {}'s picked {}", request.getUserEmail(), request.getNewSelected());

        request.setActiveSeasonId(gameSettings.getActiveSeasonInt());
        boolean hasUserAlreadyPicked = selectionDao.checkForUsersPick(request.getUserEmail());

        if(hasUserAlreadyPicked)
            selectionDao.updateUsersPick(request);
        else
            selectionDao.insertUserPick(request);

        return ResponseEntity.ok("Updated");
    }

    void configGameOptions(AppData appData) {
        GameOption gameOption1 = new GameOption(1, "Option 1", false);
        GameOption gameOption2 = new GameOption(2, "Option 2", false);
        GameOption gameOption3 = new GameOption(3, "Option 3", false);

        String picked = selectionDao.getUsersSelectionToday(appData.getUserEmail());
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

    List<DetailedPickHistory> getAllTodaysSelections() {
       return selectionDao.getAllTodaysSelections(DateManagerUtil.getTodaysDateString());
    }


    void setSelectionAsWinner(Integer selectionToUpdate, String dateString) {
        if(selectionToUpdate != null) {
            selectionDao.setSelectionAsWinner(selectionToUpdate, dateString);
        }
    }


    void clearTodaysWinnerAsCaution(String dateString) {
        logger.warn("Clearing now because of cron job is every 20 secs or so.");
        selectionDao.clearTodaysWinnerAsCaution(dateString);
    }

    void getLeadersPickForHint(AppData appData) {
        User leader = selectionDao.getLeader(gameSettings.getActiveSeasonInt());

        if(leader != null) {
            if(leader.getUserEmail().equals(appData.getUserEmail())) {
                appData.setHint(null);
            }else {
                String leadersPick = selectionDao.getUsersSelectionToday(leader.getUserEmail());
                if(leadersPick != null)
                    appData.setHint(String.format(
                            "Fun fact: The current leader chose option %s for today's selection.", selectionDao.getUsersSelectionToday(leader.getUserEmail())
                    ));
                else
                    appData.setHint("Leader hasn't made their pick yet today.");
            }
        }


    }

}