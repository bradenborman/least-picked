package com.borman.leastpicked.services;

import com.borman.leastpicked.modls.database.DetailedPickHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

//0 0 0 * * ?	Every day at midnight - 12am

@Service
public class CalculatePointsService {


    @Autowired
    SelectionService selectionService;

    private final Logger logger = LoggerFactory.getLogger(CalculatePointsService.class);

    @Scheduled(cron = "0 * * ? * *") //Every Min
    public void calculateScores() {
        logger.info("task hit: calculateScores");
        List<DetailedPickHistory> todaysResults = selectionService.getAllTodaysSelections();
        logger.info("Today's Results size: {}", todaysResults.size());

        //TODO update row mapper -- everything is null
    }



}