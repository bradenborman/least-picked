package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.UserDao;
import com.borman.leastpicked.modls.AppData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);


    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean insertUserIfNecessary(String userEmail, String playerName) {
        boolean wasInserted = userDao.insertUserIfNecessary(userEmail, playerName);

        if(wasInserted)
            logger.info("{} was inserted into the database.", userEmail);

        return wasInserted;

    }
    public void setUsersScore(AppData appData, String seasonId) {
        appData.setUserScore(
               Integer.parseInt(userDao.getUsersScoreForSeason(appData.getUserEmail(), seasonId))
        );
    }

}