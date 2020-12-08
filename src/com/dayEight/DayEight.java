package com.dayEight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayEight {

    private static String[][] operations = new String[649][];

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
//            System.out.println(operations[i][0]);
//            String valueAsString = operations[j][0].split(" ")[1];
//            System.out.println(valueAsString);
//            int value = 1;
            int value = Integer.parseInt(operations[j][0].split(" ")[1]);
            String action = operations[j][0].split( " ")[0];
//            System.out.println(action);
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

}
