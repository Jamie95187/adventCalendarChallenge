package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
//    private ArrayList<String> correctMessages = new ArrayList<> ();
//    public int numberOfCorrectRules = 0;
//    private String[] zeroMessage;
    public Queue<String> queue = new LinkedList<String>();
    public ArrayList<String> validRules = new ArrayList<>();
    public ArrayList<String> messagesToBeChecked = new ArrayList<>();

//    public void readMessages() {
//        for (int i = 0; i < 130; i++) {
//            messages.add(new Rule());
//        }
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNineteen/messageData.txt"
//            ));
//            String line = reader.readLine();
//            int counter = 1;
//            while (line != null && counter < 130) {
//                int index = Integer.parseInt(line.substring(0, line.indexOf(':')));
//                if (index == 0) {
//                    zeroMessage = line.substring(line.indexOf(':')+1).trim().split(" ");
//                }
//                if (line.contains("|")) {
//                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1, line.indexOf("|")));
//                    messages.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
//                } else {
//                    messages.get(index).setLeftRule(line.substring(line.indexOf(':')+1));
//                }
//                counter++;
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void addToInitialStack() {
        queue.add("4 1 5");
        testSetup();
        populateMessagesToBeChecked();
    }

    public ArrayList<Rule> testSetup() {
        ArrayList<Rule> messagesExample = new ArrayList<>();
        Rule rule0 = new Rule();
        rule0.setLeftRule("4 1 5");
        Rule rule1 = new Rule();
        rule1.setLeftRule("2 3");
        rule1.setRightRule("3 2");
        Rule rule2 = new Rule();
        rule2.setLeftRule("4 4");
        rule2.setRightRule("5 5");
        Rule rule3 = new Rule();
        rule3.setLeftRule("4 5");
        rule3.setRightRule("5 4");
        Rule rule4 = new Rule();
        rule4.setLeftRule("a");
        Rule rule5 = new Rule();
        rule5.setLeftRule("b");
        messagesExample.add(rule0);
        messagesExample.add(rule1);
        messagesExample.add(rule2);
        messagesExample.add(rule3);
        messagesExample.add(rule4);
        messagesExample.add(rule5);
        return messagesExample;
    }

    public void checkRule(String rule) {
        String[] splitRule = rule.trim().split(" ");
        String left;
        String right;
        int index = 0;
        for (int i = 0; i < splitRule.length; i++) {
            // Not equal to rule where they return "a" or "b"
            if (!splitRule[i].equals("4") | !splitRule[i].equals("5")) {
                index = i;
            }
        }
        for (int i = 0; i != index && i < splitRule.length; i++) {
            
        }
    }

    public void testMethod2(String message) {
        ArrayList<Rule> messagesExample = testSetup();
        String[] splitMessage = message.trim().split(" ");
        String left;
        String right;
        if (message.length() == 5) {
            left = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).left + " " + splitMessage[2];
            right = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).right + " " + splitMessage[2];
        } else {
            left = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).left + " " + splitMessage[2] + " " + splitMessage[3];
            right = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).right + " " + splitMessage[2] + " " + splitMessage[3];
        }
        queue.add(left);
        queue.add(right);
    }

    public void testMethod3(String message) {
        ArrayList<Rule> messagesExample = testSetup();
        String[] splitMessage = message.trim().split(" ");
        String left = splitMessage[0] + " " + splitMessage[1] + " " + splitMessage[2] + " " + messagesExample.get(Integer.parseInt(splitMessage[3])).left + " " + splitMessage[4];
        String right = splitMessage[0] + " " + splitMessage[1] + " " + splitMessage[2] + " " + messagesExample.get(Integer.parseInt(splitMessage[3])).right + " " + splitMessage[4];
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

        testSetup();
        System.out.println("Before test method 2 queue: ");
        testPrintQueue();

        testMethod2(queue.poll());;
        System.out.println("--------------------------------------------------------");
        System.out.println("After 1st  test method 2: ");
        testPrintQueue();

        testMethod2(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 2nd test method 2: ");
        testPrintQueue();

        testMethod2(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 3rd test method 2: ");
        testPrintQueue();

        testMethod3(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 1st test method 3: ");
        testPrintQueue();


        testMethod3(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 2nd test method 3: ");
        testPrintQueue();

        testMethod3(queue.poll());
        System.out.println("--------------------------------------------------------");
        System.out.println("After 3rd test method 3: ");
        testPrintQueue();

        testMethod3(queue.poll());
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

    public void populateMessagesToBeChecked() {
        messagesToBeChecked.add("ababbb");
        messagesToBeChecked.add("bababa");
        messagesToBeChecked.add("abbbab");
        messagesToBeChecked.add("aaabbb");
        messagesToBeChecked.add("aaaabbb");
    }

//    public void printMessages() {
//        for (int i = 0; i < messages.size(); i++) {
//            System.out.println("Index: " + i + " Left message: " + messages.get(i).left + " Right message: " + messages.get(i).right);
//        }
//    }

}
