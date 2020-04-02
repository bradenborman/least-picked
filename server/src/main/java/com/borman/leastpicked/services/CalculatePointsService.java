package com.borman.leastpicked.services;

import com.borman.leastpicked.modls.database.DetailedPickHistory;
import com.borman.leastpicked.utilities.CalculatePointsUtility;
import com.borman.leastpicked.utilities.DateManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.stream.Collectors;

//0 0 0 * * ?	Every day at midnight - 12am
//0 59 23 * * ?	Every day at midnight - 12am

@Service
public class CalculatePointsService {


    @Autowired
    private SelectionService selectionService;

    private final Logger logger = LoggerFactory.getLogger(CalculatePointsService.class);

    @Scheduled(cron = "0/15 * * * * *") //Every Min
    public void calculateScores() {

        String dateString = DateManagerUtil.getTodaysDateString();
        selectionService.clearTodaysWinnerAsCaution(dateString);

        List<Integer> optionsPicked =  selectionService.getAllTodaysSelections().stream()
                .map(DetailedPickHistory::getOptionSelected)
                .collect(Collectors.toList());

        List<Integer> winners = CalculatePointsUtility.countFrequencies(optionsPicked);
        logger.info("Selections that get points:");
        winners.forEach(y -> {
            logger.info("{}", y);
            selectionService.setSelectionAsWinner(y, dateString);
        });

    }



}