package com.borman.leastpicked.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateManagerUtil {

    public static String getTodaysDateString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

}