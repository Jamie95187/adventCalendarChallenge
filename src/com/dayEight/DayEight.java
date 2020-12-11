package com.dayEight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class DayEight {

    private static String[][] operations = new String[649][];
    private static Queue<String[]> queue = new LinkedList<>();
    private static int count = 0;

    public void readFile(){
        BufferedReader reader;
        int i = 0;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEight/Instructions.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    String[] operator = new String[2];
                    // line = "nop 134"
                    // operator = [line, 0]
                    operator[0] = line;
                    operator[1] = "0";
                    operations[i] = operator;
                    i++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countValueOfAccumulator() {
        count = 0;
        int j = 0;
        for (int i = 0; i < operations.length; i++) {
            // value = "+45" | "-45"
            int value = Integer.parseInt(operations[j][0].split(" ")[1]);
            // action = "nop"
            String action = operations[j][0].split( " ")[0];
            String[] queueAction = new String[2];
            queueAction[0] = action;
            queueAction[1] = Integer.toString(j);
            queue.add(queueAction);
            if (operations[j][1] == "1") {
                return count;
            }
            operations[j][1] = "1";
            if (action.contains("acc")){
                count = count + value;
                j++;
            } else if (action.contains("jmp")) {
                j = j + value;
            } else {
                j++;
            }
        }
        return count;
    }

    private void checkIfFinished(String[][] listOfOperations) {
        int indexOfOperation = 0;
        for (int i = 0; i < listOfOperations.length; i++){
            int value = Integer.parseInt(listOfOperations[indexOfOperation][0].split(" ")[1]);
            String action = listOfOperations[indexOfOperation][0].split(" ")[0];
        }
    }

    public void checkForIndex() {
        int index = Integer.parseInt(queue.remove()[1]);
        String[][] copyOfOperations = operations;


    }

}
