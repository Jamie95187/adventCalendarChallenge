package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MonsterMessage {

    public void readMessages() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/messageData.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                System.out.println(line);
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String solver() {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(0, "1");
        hmap.put(1, "3");
        hmap.put(2, "4");
        hmap.put(3, "a");
        hmap.put(4, "b");
        return hmap.get(Integer.parseInt(hmap.get(Integer.parseInt(hmap.get(0)))));
    }

}
