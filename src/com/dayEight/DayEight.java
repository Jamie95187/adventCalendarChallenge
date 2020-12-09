package com.dayEight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class DayEight {

    private static String[][] operations = new String[649][];
    private static Queue<String[]> queue = new LinkedList<>();

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
        int count = 0;
        int j = 0;
        for (int i = 0; i < operations.length; i++) {
            int value = Integer.parseInt(operations[j][0].split(" ")[1]);
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
//            System.out.println("Poela = " + operations[j][0]);
        }
        return count;
    }

    public boolean checkForCompletion(String[][] operationsList) {
        boolean complete = false;
        int j = 0;
        for (int i = 0; i < operationsList.length; i++) {
            int value = Integer.parseInt(operationsList[j][0].split(" ")[1]);
            String action = operationsList[j][0].split( " ")[0];
            if (operationsList[j][1] == "1") {
                return false;
            }
            operationsList[j][1] = "1";
            if (action.contains("acc")){
                j++;
            } else if (action.contains("jmp")) {
                j = j + value;
            } else {
                j++;
            }
            if (j == operationsList.length - 1) {
                System.out.println("COmPLETED");
                return true;
            }
        }
        return complete;
    }

    public int findIndex() {
        int indexToChange = 0;
//        System.out.println(queue.size());
        for(int i = 0; i < queue.size(); i++) {
            String[][] copyOfOperations = operations;
            String[] head = queue.remove();
            if (head[0].contains("jmp")) {
                indexToChange = Integer.parseInt(head[1]);
                changeIndex(indexToChange, copyOfOperations);
                if (checkForCompletion(copyOfOperations) == true) {
                    System.out.println("Henlo One");
                    break;
                }
            } else if (head[0].contains("nop")) {
                indexToChange = Integer.parseInt(head[1]);
                changeIndex(indexToChange, copyOfOperations);
                if (checkForCompletion(copyOfOperations) == true) {
                    System.out.println("Henlo Two");
                    break;
                }
            }
        }

        return indexToChange;
    }

    public void changeIndex(int i, String[][] op) {
        int value = Integer.parseInt(op[i][0].split(" ")[1]);
        String action = op[i][0].split( " ")[0];
        if(action.contains("jmp")){
            op[i][0] = "nop " + value;
        } else {
            op[i][0] = "jmp " + value;
        }
    }

}
