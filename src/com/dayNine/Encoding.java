package com.dayNine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Encoding {

    private static List<Long> data = new ArrayList<>();

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNine/data.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                data.add(Long.parseLong(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        for (Long input : data){
            System.out.println(input);
        }
    }
}
