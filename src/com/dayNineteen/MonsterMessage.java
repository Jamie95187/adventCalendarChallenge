package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
    private ArrayList<Rule> exampleData = new ArrayList<> (6);
//    private ArrayList<String> correctMessages = new ArrayList<> ();
//    public int numberOfCorrectRules = 0;
    public Queue<String> queue = new LinkedList<String>();
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
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/exampleData.txt"
//            ));
//            String line = reader.readLine();
//            int counter = 0;
//            while (line != null && counter < 5) {
//                int index = Integer.parseInt(line.substring(0, line.indexOf(':')));
//                if (line.contains("|")) {
//                    exampleData.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
//                    exampleData.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
//                } else {
//                    exampleData.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
//                }
//                counter++;
//                line = reader.readLine();
//            }
//            reader.readLine();
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
//        readExampleData();
        readMessages();
//        Used for testing example data
//        queue.add(exampleData.get(0).left.trim());
        queue.add(messages.get(0).left.trim());
    }

    public void checkRule(String rule) {
        String[] splitRule = rule.trim().split(" ");
//        Used for testing example data
//        ArrayList<Rule> messagesExample = exampleData;
        ArrayList<Rule> messagesExample = messages;
        String left = "";
        String right= "";
        int index = 0;
        for (int i = 0; i < splitRule.length; i++) {
            // Not equal to rule where they return "a" or "b"
            if (!splitRule[i].equals("4") && !splitRule[i].equals("5")) {
                index = i;
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
        queue.add(right);
    }

    public boolean testCheck(String message){
        for (String s : message.split(" ")) {
            if (!s.trim().equals("4") & !s.trim().equals("5")) {
                return false;
            }
        }
        return true;
    }

    public void testIteratorMethod() {

        System.out.println("Before test method 2 queue: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 1st test method 2: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 2nd test method 2: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 3rd test method 2: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 1st test method 3: ");
        testPrintQueue();


        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 2nd test method 3: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 3rd test method 3: ");
        testPrintQueue();

        checkRule(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 2nd test method 3: ");
        testPrintQueue();

        if (testCheck(queue.peek())) {
            populateValidRules(queue);
        }

        printValidRules();
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
                if (index.equals("4")) {
                    validRule += "a";
                }
                if (index.equals("5")) {
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
