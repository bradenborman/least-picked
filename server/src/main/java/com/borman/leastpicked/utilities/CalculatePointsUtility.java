package com.borman.leastpicked.utilities;

import java.util.*;

public class CalculatePointsUtility {

    public static List<Integer> countFrequencies(List<Integer> list)
    {
        // hashmap to store the frequency of element
        Map<String, Integer> map = new HashMap<>();

        for (Integer i : list) {
            Integer j = map.get(String.valueOf(i));
            map.put(String.valueOf(i), (j == null) ? 1 : j + 1);
        }

        List<Integer> lowestOccurringValues = new ArrayList<>();
        int toCompareTo = map.get("1");

        for (Map.Entry<String, Integer> val : map.entrySet()) {
            System.out.println("Element " + val.getKey() + " occurs: " + val.getValue() + " times");
            if(val.getValue() == toCompareTo)
                lowestOccurringValues.add(Integer.valueOf(val.getKey()));
            else if(val.getValue() < toCompareTo){
                lowestOccurringValues.clear();
                lowestOccurringValues.add(Integer.valueOf(val.getKey()));
            }
        }

        return lowestOccurringValues;

    }

}