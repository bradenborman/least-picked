package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public void insertUserIfNessary(String userEmail) {
        userDao.insertUserIfNessary(userEmail);
    }


}