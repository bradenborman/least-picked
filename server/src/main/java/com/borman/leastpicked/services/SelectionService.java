package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.AppData;
import com.borman.leastpicked.modls.GameOption;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
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

    public SelectionService(SelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public ResponseEntity<String> updateSelection(UpdateSelectionRequest request) {
        logger.info("User {}'s picked {}", request.getUserEmail(), request.getNewSelected());

        boolean hasUserAlreadyPicked = selectionDao.checkForUsersPick(request.getUserEmail());

        if(hasUserAlreadyPicked)
            selectionDao.updateUsersPick(request);
        else
            selectionDao.insertUserPick(request);

        return ResponseEntity.ok("Updated");
    }

    public void configGameOptions(AppData appData) {
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

}