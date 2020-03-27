package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


    public boolean insertUserIfNessary(String userEmail) {
        boolean wasInserted = userDao.insertUserIfNecessary(userEmail);

        if(wasInserted)
            logger.info("{} was inserted into the database.", userEmail);

        return wasInserted;

    }


}