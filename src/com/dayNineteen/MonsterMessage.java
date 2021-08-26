package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
    private ArrayList<String> correctRules = new ArrayList<> ();
    private int numberOfCorrectRules = 0;
    private String zeroMessage;

    public void readMessages() {
        for (int i = 0; i < 130; i++) {
            messages.add(new Rule(""));
        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/messageData.txt"
            ));
            String line = reader.readLine();
            int counter = 1;
            while (line != null && counter < 130) {
                int index = Integer.parseInt(line.substring(0, line.indexOf(':')));
                System.out.println(line);
                if (line.contains("|")) {
                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
                    messages.get(index).setRightRule(line.substring(line.indexOf("|")).trim());
                } else {
                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
                }
                counter++;
                line = reader.readLine();
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

    public void iterator() {
    }

    public void printMessages() {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println("Index: " + i + " Left message: " + messages.get(i).left + " Right message: " + messages.get(i).right);
        }
    }

}
