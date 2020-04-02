package com.borman.leastpicked.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CalculatePointsUtility {

    private static Logger logger = LoggerFactory.getLogger(CalculatePointsUtility.class);

    public static List<Integer> countFrequencies(List<Integer> list) {
        // hashmap to store the frequency of element
        Map<String, Integer> map = new HashMap<>();

        for (Integer i : list) {
            Integer j = map.get(String.valueOf(i));
            map.put(String.valueOf(i), (j == null) ? 1 : j + 1);
        }

        List<Integer> lowestOccurringValues = new ArrayList<>();

        Integer toCompareTo = -1;

        if(map.containsKey("1"))
            toCompareTo = map.get("1");
        else if(map.containsKey("2"))
            toCompareTo = map.get("2");
        else if(map.containsKey("3"))
            toCompareTo = map.get("3");

        for (Map.Entry<String, Integer> val : map.entrySet()) {
            logger.info("Element {} occurs: {} times", val.getKey(), val.getValue());
            if(val.getValue().equals(toCompareTo))
                lowestOccurringValues.add(Integer.valueOf(val.getKey()));
            else if(val.getValue() < toCompareTo){
                lowestOccurringValues.clear();
                lowestOccurringValues.add(Integer.valueOf(val.getKey()));
            }
        }

        return lowestOccurringValues;

    }

}