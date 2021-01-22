package com.dayFifteen;

import java.util.HashMap;
import java.util.Map;

public class MemoryGame {

    private int previousNumber;
    Map<Integer, SpokenNumber> history = new HashMap<>();

    public void game(int[] inputData) {
        addInitialDataToHistory(inputData);
        previousNumber = inputData[inputData.length -1];
        int indexTracker = inputData.length + 1;
        for (int i = indexTracker; i <= 10; i++) {
//            System.out.println("previous spoken : " +  history.get(previousNumber).getPreviouslySpoken());
            int age = 0;
            if (history.containsKey(previousNumber)) {
                age =  (i - 1) - history.get(previousNumber).getPreviouslySpoken();
                history.get(previousNumber).setPreviouslySpoken(i - 1);
            } else {
                SpokenNumber newEntry = new SpokenNumber(previousNumber, i);
                history.put(previousNumber, newEntry);
            }
            previousNumber = age;
            System.out.println("PN : " + previousNumber);
        }
        System.out.println(previousNumber);
    }

    private void addInitialDataToHistory(int[] inputData) {
        System.out.println("LENGTH : " + inputData.length);
        for (int i = 1; i <= inputData.length; i++) {
            SpokenNumber number = new SpokenNumber(inputData[i - 1], i);
            history.put(inputData[i - 1], number);
        }
    }

}
