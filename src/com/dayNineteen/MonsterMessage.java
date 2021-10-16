package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
//    private ArrayList<Rule> exampleData = new ArrayList<> (6);
//    private ArrayList<Rule> exampleDataTwo = new ArrayList<> (4);
    public Queue<String> queue = new LinkedList<>();
    public ArrayList<String> validRules = new ArrayList<>();
    public ArrayList<String> messagesToBeChecked = new ArrayList<>();

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
                if (line.contains("|")) {
                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
                    messages.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
                    messages.get(index).hasRight = true;
                } else {
                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
                }
                counter++;
                line = reader.readLine();
            }
            line = reader.readLine();
            while (line != null) {
                messagesToBeChecked.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

//    public void readExampleData() {
//        for (int i = 0; i < 5; i++) {
//            exampleData.add(new Rule());
//        }
//        for (int i = 0; i < 4; i++) {
//            exampleDataTwo.add(new Rule());
//        }
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(
//        "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/exampleDataTwo.txt"
//               "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/exampleData.txt"
//            ));
//            String line = reader.readLine();
//            int counter = 0;
//            while (line != null && counter < 4) {
//                int index = Integer.parseInt(line.substring(0, line.indexOf(':')));
//                if (line.contains("|")) {
//                    exampleDataTwo.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
//                    exampleDataTwo.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
//                    exampleDataTwo.get(index).hasRight = true;
//                    exampleData.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
//                    exampleData.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
//                } else {
//                    exampleDataTwo.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
//                    exampleData.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
//                }
//                counter++;
//                line = reader.readLine();
//            }
//            line = reader.readLine();
//            while (line != null) {
//                messagesToBeChecked.add(line);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void addToInitialStack() {
        readMessages();
//        Used for testing example data
//        readExampleData();
//        queue.add(exampleDataTwo.get(0).left.trim());
//        queue.add(exampleData.get(0).left.trim());
        queue.add(messages.get(0).left.trim());
    }

    public void checkRule(String rule) {
        String[] splitRule = rule.trim().split(" ");
//        Used for testing example data
//        ArrayList<Rule> messagesExample = exampleData;
//        ArrayList<Rule> messagesExample = exampleDataTwo;
        ArrayList<Rule> messagesExample = messages;
        String left = "";
        String right= "";
        int index = 0;
        for (int i = 0; i < splitRule.length; i++) {
//             Not equal to rule where they return "a" or "b"
//             For example data 2
//            if (!splitRule[i].equals("1") && !splitRule[i].equals("3")) {
//                index = i;
//                break;
//            }

            if (!splitRule[i].equals("50") && !splitRule[i].equals("64")) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < splitRule.length; i++) {
            if (i == index) {
                left += messagesExample.get(Integer.parseInt(splitRule[i])).left.trim() + " ";
                if (messagesExample.get(Integer.parseInt(splitRule[i])).hasRight) {
                    right += messagesExample.get(Integer.parseInt(splitRule[i])).right.trim() + " ";
                }
            } else {
                left += splitRule[i].trim() + " ";
                right += splitRule[i].trim() + " ";
            }
        }
        left = left.trim();
        right = right.trim();
        queue.add(left);

        if (messagesExample.get(Integer.parseInt(splitRule[index])).hasRight) {
            queue.add(right);
        }

    }

    public boolean testCheck(String message){
        for (String s : message.split(" ")) {
            if (!s.trim().equals("50") & !s.trim().equals("64")) {
                return false;
            }
//            if (!s.trim().equals("4") & !s.trim().equals("5")) {
//                return false;
//            }
        }
        return true;
    }

    public void testIteratorMethod() {

        while(!testCheck(queue.peek())) {
            checkRule(queue.poll());
        }

        if (testCheck(queue.peek())) {
            populateValidRules(queue);
        }

//        printValidRules();
    }
    
    public void testPrintQueue() {
        for (String s : queue) {
            System.out.println(s);
        }
    }

    public void populateValidRules(Queue<String> rules) {
        for (String rule : rules){
            String validRule = "";
            for(String index: rule.split(" ")) {
//                if (index.equals("1")) {
//                    validRule += "a";
//                }
//                if (index.equals("3")) {
//                    validRule += "b";
//                }
                if (index.equals("64")) {
                    validRule += "a";
                }
                if (index.equals("50")) {
                    validRule += "b";
                }
            }
            validRules.add(validRule);
        }
    }

    public void printValidRules() {
        for (int i = 0; i < validRules.size(); i++) {
            System.out.println(validRules.get(i));
        }
    }

}
