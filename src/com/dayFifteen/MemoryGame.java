package com.dayFifteen;

import java.util.HashMap;
import java.util.Map;

public class MemoryGame {

    private int previousNumber;
    Map<Integer, SpokenNumber> history = new HashMap<>();

    public void game(int[] inputData) {
        addInitialDataToHistory(inputData);
        previousNumber = inputData[inputData.length];
        int indexTracker = inputData.length + 1;
        for (int i = indexTracker; i <= 2021; i++) {
            int spokenNumber = 0;
            if (history.containsKey(previousNumber)) {
                if (history.get(previousNumber).getPreviouslySpoken() == 0) {
                    previousNumber = 0;
                } else {
                    previousNumber = history.get(previousNumber).getMostRecentlySpoken() - history.get(previousNumber).getPreviouslySpoken();
                }
            } else {
                int age = history.get(previousNumber).getMostRecentlySpoken() - history.get(previousNumber).getPreviouslySpoken();
                SpokenNumber newEntry = new SpokenNumber(previousNumber, i - 1);
                history.put(i - 1, newEntry);
                previousNumber = history.get(previousNumber).getMostRecentlySpoken() - history.get(previousNumber).getPreviouslySpoken();
            }
        }
    }

    private void addInitialDataToHistory(int[] inputData) {
        for (int i = 1; i <= inputData.length; i++) {
            SpokenNumber number = new SpokenNumber(inputData[i-1], i);
            history.put(inputData[i-1], number);
        }
    }

}
