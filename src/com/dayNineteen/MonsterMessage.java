package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
    private ArrayList<String> correctMessage = new ArrayList<> ();
    private int numberOfCorrectRules = 0;
    private String[] zeroMessage;

    public void readMessages() {
        for (int i = 0; i < 130; i++) {
            messages.add(new Rule());
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
                if (index == 0) {
                    zeroMessage = line.substring(line.indexOf(':')+1).trim().split(" ");
                }
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

    public void solverForLeftHandSide() {
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> solvedList = new LinkedList<String>();
        String message = "";
        for (String s : zeroMessage) {
            list.add(s);
        }
        while (!list.isEmpty()) {
            String s = list.removeFirst();
            System.out.println(s);
            String leftRule = messages.get(Integer.parseInt(s)).left.trim();
            if (leftRule != "64" | leftRule != "50") {
                System.out.println("hi");
                System.out.println(leftRule);
                if (leftRule.contains(" ")) {
                    list.addFirst(leftRule.split(" ")[1]);
                    list.addFirst(leftRule.split(" ")[0]);
                } else {
                    list.addFirst(leftRule);
                }
            } else {
                solvedList.add(leftRule);
            }
        }
        for (String index : solvedList) {
            message += messages.get(Integer.parseInt(index)).left;
        }
        correctMessage.add(message);
    }

    public void iterator() {
        solverForLeftHandSide();
        for (String m : correctMessage) {
            System.out.println(m);
        }
    }

    public void printMessages() {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println("Index: " + i + " Left message: " + messages.get(i).left + " Right message: " + messages.get(i).right);
        }
    }

}
