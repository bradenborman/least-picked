package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.LeaderBoardRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBoardService {


    @Autowired
    SelectionDao selectionDao;

    @Autowired
    UserService userService;


    public ResponseEntity<List<LeaderBoardRow>> getLeaderBoard() {


        userService.getAllUniqueUsersThisSeason();


        return ResponseEntity.ok(null);
    }



}