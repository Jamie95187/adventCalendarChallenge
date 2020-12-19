package com.dayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adapter {

    List<Integer> joltageArray = new ArrayList<>();

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
    }
}
