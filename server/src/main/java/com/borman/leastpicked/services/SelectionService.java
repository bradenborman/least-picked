package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SelectionService {

    private Logger logger = LoggerFactory.getLogger(SelectionService.class);


    @Autowired
    SelectionDao selectionDao;

    public ResponseEntity<String> updateSelection(UpdateSelectionRequest request) {
        logger.info("User {}'s picked {}", request.getUserEmail(), request.getNewSelected());

        boolean hasUserAlreadyPicked = selectionDao.checkForUsersPick(request.getUserEmail());

        if(hasUserAlreadyPicked)
            selectionDao.updateUsersPick(request);
        else
            selectionDao.insertUserPick(request);

        return ResponseEntity.ok("Updated");
    }


    public String getUsersSelectionToday(String email) {
        return selectionDao.getUsersSelectionToday(email);
    }
}