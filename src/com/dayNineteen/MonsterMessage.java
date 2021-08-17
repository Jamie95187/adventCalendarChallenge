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
            int counter = 1;
            while (line != null && counter < 130) {
                line = reader.readLine();
                System.out.println(line);
                counter++;
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public int solver() {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(0, "1 2");
        hmap.put(1, "a");
        hmap.put(2, "1 3 | 3 1");
        hmap.put(3, "b");
        int counter = 0;
        int firstMessageIndex = Integer.parseInt(hmap.get(0).split(" ")[0]);
        int secondMessageIndex = Integer.parseInt(hmap.get(0).split(" ")[1]);
        if (hmap.get(firstMessageIndex) == "a") {
            counter++;
        }
        String message = hmap.get(secondMessageIndex);
        String firstHalfMessage = message.split("\\|")[0];
        String secondHalfMessage = message.split("\\|")[1];
        if ( hmap.get(Integer.parseInt(firstHalfMessage.split(" ")[0])) == "a" && hmap.get(Integer.parseInt(firstHalfMessage.split(" ")[1])) == "b"
                || hmap.get(Integer.parseInt(secondHalfMessage.split(" ")[0])) == "b" && hmap.get(Integer.parseInt(secondHalfMessage.split(" ")[1])) == "a") {
            counter++;
        }
        return counter;
    }

}
