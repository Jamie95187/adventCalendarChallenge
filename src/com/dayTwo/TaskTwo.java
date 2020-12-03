package com.dayTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskTwo {

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwo/passwords.txt"
            ));
            String line = reader.readLine();
            while (line!=null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
