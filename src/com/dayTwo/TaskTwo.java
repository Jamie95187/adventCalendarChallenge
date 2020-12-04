package com.dayTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    private List<String> entries = new ArrayList<>();

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwo/passwords.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    entries.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int checkForValidEntries() {
        int validCount = 0;
        System.out.println(entries.size());
        for (String entry: entries) {
            int charCount = 0;
            int lowerBound = Integer.parseInt(entry.split("-")[0]);
            int upperBound = Integer.parseInt(entry.split("-")[1].split("\\s")[0]);
            char character = (entry.split("-")[1].split("\\s")[1].split(":")[0]).charAt(0);
            String password = entry.split("-")[1].split("\\s")[2];

            char[] charArray = password.toCharArray();
            for (char c : charArray) {
                if (c == character) {
                    charCount++;
                }
            }

            if (charCount >= lowerBound && charCount <= upperBound) {
                validCount++;
            }
        }
        return validCount;
    }

}
