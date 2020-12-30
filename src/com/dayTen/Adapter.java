package com.dayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Adapter<Hash> {

    private static List<Integer> joltageArray = new ArrayList<>();
    private static Map<Integer, Integer> joltageCount = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> consecutiveOnesCount = new HashMap<Integer, Integer>();

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

    public void populateConsecutiveOnesMap(){
        // Populate array such that [numConsecOnes, amountOfOccurrence]
        int count = 1;
        for (int i = 0; i < joltageArray.size() - 1; i++) {
            if (joltageArray.get(i) == (joltageArray.get(i+1) - 1)) {
//                System.out.println("ELE ONE : " + joltageArray.get(i) + " ELE TWO : " + (joltageArray.get(i+1) - 1));
                count++;
            } else {
                if (count >= 3) {
//                    System.out.println("loop 2");
                    if (consecutiveOnesCount.containsKey(count)) {
                        consecutiveOnesCount.put(count, consecutiveOnesCount.get(count) + 1);
                    } else {
                       consecutiveOnesCount.put(count, 1);
                    }
                }
                count = 1;
            }
            if (i == joltageArray.size() - 1) {
                if (count >= 3) {
                    if (consecutiveOnesCount.containsKey(count)) {
                        consecutiveOnesCount.put(count, consecutiveOnesCount.get(count) + 1);
                    } else {
                        consecutiveOnesCount.put(count, 1);
                    }
                }
            }
        }
    }

    public void printConsecutiveOnesMap() {
        for(Map.Entry<Integer, Integer> entry : consecutiveOnesCount.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

    public int findJoltageArrangements() {
        // Difference of three doesnt change the arrangements count as one combination
        int count = 0;
        return count;
    }

    /*
    16
    10
    15
    5
    1
    11
    7
    19
    6
    12
    4

    (0), 1, 4, 5, 6, 7, 10, 11, 12, 15, 16, 19, (22)
    (0), 1, 4, 5, 6, 7, 10, 12, 15, 16, 19, (22)
    (0), 1, 4, 5, 7, 10, 11, 12, 15, 16, 19, (22)
    (0), 1, 4, 5, 7, 10, 12, 15, 16, 19, (22)
    (0), 1, 4, 6, 7, 10, 11, 12, 15, 16, 19, (22)
    (0), 1, 4, 6, 7, 10, 12, 15, 16, 19, (22)
    (0), 1, 4, 7, 10, 11, 12, 15, 16, 19, (22)
    (0), 1, 4, 7, 10, 12, 15, 16, 19, (22)

    [4, 5, 6, 7] 4 consecutive ones
    [10, 11, 12] 3 consecutive ones
    [15, 16] 2 consecutive ones

    ways of arranging 4 consecutive ones
    [4, 7]
    [4, 6, 7]
    [4, 5, 7]
    [4, 5, 6, 7]

    ways of arranging 3 consecutive ones
    [10, 12]
    [10, 11, 12]

    ways of arranging 2 consecutive ones
    [15, 16]

    4 * 2 * 1 = 8

     */

    public void printAnswerTwo() {
        long ans = 1;
        for (Map.Entry<Integer, Integer> entry : consecutiveOnesCount.entrySet()) {
            if (entry.getKey() ==  3) {
                ans = ans * (long) Math.pow(3, entry.getValue());
            } else if (entry.getKey() == 4) {
                ans = ans *  (long) Math.pow(4, entry.getValue());
            } else if (entry.getKey() == 5) {
                ans = ans * (long) Math.pow(7, entry.getValue());
            }
        }
        System.out.println("Answer : "+ ans);
    }
}

