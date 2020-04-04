package com.borman.leastpicked.services;

import com.borman.leastpicked.dao.SelectionDao;
import com.borman.leastpicked.modls.LeaderBoardRow;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBoardService {

    private SelectionDao selectionDao;

    public LeaderBoardService(SelectionDao selectionDao) {
        this.selectionDao = selectionDao;
    }

    public ResponseEntity<List<LeaderBoardRow>> getLeaderBoard() {
        return ResponseEntity.ok(selectionDao.getTopTenLeadersThisSeason("1"));
    }

}