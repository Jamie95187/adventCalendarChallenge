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

    private long findNumber(int n) {
        long number = data.get(n+25);
        boolean valid = false;
            for (int i = n; i < n+25; i++) {
                for (int j = n; j < i; i++) {
                    if (data.get(i) + data.get(j) == number) {
                        valid = true;
                    }
                }
                for (int k = n + i; k < n+25; k++) {
                    if (data.get(i) + data.get(k) == number) {
                        valid = true;
                    }
                }
            }
            if (!valid) {
                return data.get(n+25);
            }
        return number;
    }

    public void printAnswer(){
        for(int index = 0; index < data.size() - 26; index++) {
            if (findNumber(index) > 0L) {
                System.out.println(findNumber(index));
            }
        }
    }

    public void printData() {
        for (Long input : data){
            System.out.println(input);
        }
    }
}
