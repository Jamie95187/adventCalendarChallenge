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
        for (int i = indexTracker; i <= 2020; i++) {
            int spokenNumber = 0;
            if (history.containsKey(previousNumber) ) {
                if (history.get(previousNumber).getPreviouslySpoken() == 0) {
                    history.get(previousNumber).setPreviouslySpoken(history.get(previousNumber).getMostRecentlySpoken());
                    history.get(previousNumber).setMostRecentlySpoken(i);
                    int age = i - history.get(previousNumber).getMostRecentlySpoken();
                    if (history.containsKey(age)) {
                        if (history.get(age).getPreviouslySpoken() == 0) {
                            
                        }
                    }
                } else {

                }
                int age = history.get(previousNumber).getMostRecentlySpoken() - history.get(previousNumber).getPreviouslySpoken();
                previousNumber = age;
            } else {
                SpokenNumber number = new SpokenNumber(0, i)
                previousNumber = 0;
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
