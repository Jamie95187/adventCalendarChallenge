package com.dayEight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class DayEight {

    private static String[][] operations = new String[649][];
    public Queue<String[]> queue = new LinkedList<String[]>();
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

    private boolean checkIfFinished(String[][] listOfOperations) {
        int indexOfOperation = 0;
        while (indexOfOperation < listOfOperations.length){
            int value = Integer.parseInt(listOfOperations[indexOfOperation][0].split(" ")[1]);
            String action = listOfOperations[indexOfOperation][0].split(" ")[0];
//            System.out.println(indexOfOperation + " visited? = " + listOfOperations[indexOfOperation][1]);
            if (listOfOperations[indexOfOperation][1] == "1") {
//                System.out.println("return false");
                return false;
            }
            listOfOperations[indexOfOperation][1] = "1";
            if (action.contains("jmp")) {
                indexOfOperation = indexOfOperation + value;
            } else {
                indexOfOperation++;
            }
        }
        if (indexOfOperation >= listOfOperations.length - 1) {
            System.out.println("Henlo from true");
            return true;
        }
        return false;
    }

    public void accCount() {
        int i = 0;
        clearVisited();
        for (String[] queueItem: queue) {
            System.out.println("QueueItem = " + queueItem[0]);
            System.out.println("BEFORE CHANGING = " + operations[Integer.parseInt(queueItem[1])][0]);
            String[][] copyOfOperations = changeAtIndex(Integer.parseInt(queueItem[1]));
            System.out.println("AFTER CHANGING = " + copyOfOperations[Integer.parseInt(queueItem[1])][0]);
            if (!queueItem[0].contains("acc")) {
                System.out.println("Not ACC");
                if (checkIfFinished(copyOfOperations)) {
                    System.out.println("Henlo");
                    System.out.println(getAccForTaskTwo(copyOfOperations));
                    break;
                }
            }

        }
    }

    private int getAccForTaskTwo(String[][] listOfOperations) {
        count = 0;
        int j = 0;
        for (int i = 0; i < listOfOperations.length; i++) {
            // value = "+45" | "-45"
            int value = Integer.parseInt(listOfOperations[j][0].split(" ")[1]);
            // action = "nop"
            String action = listOfOperations[j][0].split( " ")[0];
            String[] queueAction = new String[2];
            queueAction[0] = action;
            queueAction[1] = Integer.toString(j);
            queue.add(queueAction);
            if (listOfOperations[j][1] == "1") {
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

    private String[][] changeAtIndex(int i) {
        String[][] copyListOfOperations = operations;
        String action = copyListOfOperations[i][0].split(" ")[0];
        String value = copyListOfOperations[i][0].split(" ")[1];
        if (action.contains("jmp")) {
            copyListOfOperations[i][0] = "nop" + " " + value;
        } else if (action.contains("nop")) {
            copyListOfOperations[i][0] = "jmp" + " " + value;
        }
        return copyListOfOperations;
    }

    public Queue<String[]> getQueue(){
        return queue;
    }

    public String[][] getOperations() {
        return operations;
    }

    public void clearVisited() {
        for (int i = 0; i < operations.length; i++) {
            operations[i][1] = "0";
        }
    }
}
