package com.dayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Adapter<Hash> {

    private static List<Integer> joltageArray = new ArrayList<>();
    private static Map<Integer, Integer> joltageCount = new HashMap<Integer, Integer>();

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTen/joltage.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                joltageArray.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortList() {
        Collections.sort(joltageArray);
    }

    public void printData(){
        for(int jolt : joltageArray) {
            System.out.println(jolt);
        }
        System.out.println("SIZE = " + joltageArray.size());
    }

    private void countJoltDifferences() {
        int firstDif  = joltageArray.get(0);
        joltageCount.put(firstDif, 1);
        for (int i = 1; i < joltageArray.size(); i++) {
            int difference = joltageArray.get(i) - joltageArray.get(i-1);
            if ( difference == 1 ) {
                if (!joltageCount.containsKey(difference)) {
                    joltageCount.put(difference, 1);
                } else {
                    joltageCount.put(difference, joltageCount.get(1) + 1);
                }
            } else if ( difference == 2 ) {
                if (!joltageCount.containsKey(difference)) {
                    joltageCount.put(difference, 1);
                } else {
                    joltageCount.put(difference, joltageCount.get(difference) + 1);
                }
            } else {
                if (!joltageCount.containsKey(difference)) {
                    joltageCount.put(difference, 1);
                } else {
                    joltageCount.put(difference, joltageCount.get(difference) + 1);
                }
            }
        }
        joltageCount.put(3, joltageCount.get(3) + 1);
    }

    public Map<Integer, Integer> getJoltageCount() {
        countJoltDifferences();
        return joltageCount;
    }
}
