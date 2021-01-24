package com.dayFifteen;

import java.util.HashMap;
import java.util.Map;

public class MemoryGame {

    private int previousNumber;
    Map<Integer, SpokenNumber> history = new HashMap<>();

    public void game(int[] inputData) {
        addInitialDataToHistory(inputData);
        previousNumber = inputData[2];
        int indexTracker = inputData.length + 1;
        for (int i = indexTracker; i <= 2020; i++) {
            int age = 0;
            if (history.containsKey(previousNumber)) {
                age =  (i - 1) - history.get(previousNumber).getPreviouslySpoken();
                history.get(previousNumber).setPreviouslySpoken(i - 1);
            } else {
                SpokenNumber newEntry = new SpokenNumber(previousNumber, i - 1);
                history.put(previousNumber, newEntry);
            }
            previousNumber = age;
        }
        System.out.println(previousNumber);
    }

    private void addInitialDataToHistory(int[] inputData) {
        for (int i = 1; i <= inputData.length; i++) {
            SpokenNumber number = new SpokenNumber(inputData[i - 1], i);
            history.put(inputData[i - 1], number);
        }
    }

}
