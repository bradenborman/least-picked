package com.borman.leastpicked.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class SeasonUtility {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static long getDaysLeftInCurrentSeason(String dateToCalc) {
        return ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(dateToCalc, DATE_FORMAT));
    }

}