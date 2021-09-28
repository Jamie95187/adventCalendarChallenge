package com.dayNineteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MonsterMessage {

    private ArrayList<Rule> messages = new ArrayList<> (130);
    private ArrayList<String> correctMessages = new ArrayList<> ();
    private int numberOfCorrectRules = 0;
    private String[] zeroMessage;
    private Stack<String> stack = new Stack<String>();

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
                    messages.get(index).setRightRule(line.substring(line.indexOf("|")+1).trim());
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
            if (s.equals("64") | s.equals("50")) {
                solvedList.add(s);
                continue;
            }
            String leftRule = messages.get(Integer.parseInt(s)).left.trim();
            if (leftRule.contains(" ")) {
                if (leftRule.split(" ")[0].equals("64") | leftRule.split(" ")[0].equals("50")) {
                    list.addFirst(leftRule.split(" ")[1]);
                    solvedList.add(leftRule.split(" ")[0]);
                } else if (leftRule.split(" ")[0].equals("64") | leftRule.split(" ")[0].equals("50")
                && leftRule.split(" ")[1].equals("64") | leftRule.split(" ")[1].equals("50")) {
                    solvedList.add(leftRule.split(" ")[0]);
                    solvedList.add(leftRule.split(" ")[1]);
                } else {
                    list.addFirst(leftRule.split(" ")[1]);
                    list.addFirst(leftRule.split(" ")[0]);
                }
            } else {
                if (!leftRule.equals("64") | !leftRule.equals("50")) {
                    list.addFirst(leftRule);
                }
            }
        }
        for (String index : solvedList) {
            if (index.equals("64")) {
                message = message + "a";
            } else {
                message = message + "b";
            }
        }
        correctMessages.add(message);
    }

    public void solverForRightHandSide() {
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> solvedList = new LinkedList<String>();
        String message = "";
        for (String s : zeroMessage) {
            list.add(s);
        }
        while (!list.isEmpty()) {
            String s = list.removeFirst();
            if (s.equals("64") | s.equals("50")) {
                solvedList.add(s);
                continue;
            }
            String rule = "";
            if (messages.get(Integer.parseInt(s)).right.equals("")){
                rule = messages.get(Integer.parseInt(s)).left.trim();
            } else {
                rule = messages.get(Integer.parseInt(s)).right.trim();
            }
            if (rule.contains(" ")) {
                if (rule.split(" ")[0].equals("64") | rule.split(" ")[0].equals("50")) {
                    list.addFirst(rule.split(" ")[1]);
                    solvedList.add(rule.split(" ")[0]);
                } else if (rule.split(" ")[0].equals("64") | rule.split(" ")[0].equals("50")
                        && rule.split(" ")[1].equals("64") | rule.split(" ")[1].equals("50")) {
                    solvedList.add(rule.split(" ")[0]);
                    solvedList.add(rule.split(" ")[1]);
                } else {
                    list.addFirst(rule.split(" ")[1]);
                    list.addFirst(rule.split(" ")[0]);
                }
            } else {
                if (!rule.equals("64") | !rule.equals("50")) {
                    list.addFirst(rule);
                }
            }
        }
        for (String index : solvedList) {
            if (index.equals("64")) {
                message = message + "a";
            } else {
                message = message + "b";
            }
        }
        correctMessages.add(message);
    }

    public void iterator() {
        solverForLeftHandSide();
        solverForRightHandSide();
        for (String m : correctMessages) {
            System.out.println(m);
        }
    }

    public ArrayList<Rule> testSetup() {
        stack.add("4 1 5");
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

    public void testMethod2(String message) {
        ArrayList<Rule> messagesExample = testSetup();
        String[] splitMessage = message.trim().split(" ");
//        System.out.println(message);
        String left;
        String right;
        if (message.length() == 5) {
            System.out.println("message");
            left = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).left + " " + splitMessage[2];
            right = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).right + " " + splitMessage[2];
        } else {
            left = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).left + " " + splitMessage[2] + " " + splitMessage[3];
            right = splitMessage[0] + " " + messagesExample.get(Integer.parseInt(splitMessage[1])).right + " " + splitMessage[2] + " " + splitMessage[3];
        }
        stack.add(left);
        stack.add(right);
        testPrintStack();
    }

    public void testMethod3(String message) {
        ArrayList<Rule> messagesExample = testSetup();
        String[] splitMessage = message.trim().split(" ");
//        System.out.println(message);
        String left = splitMessage[0] + " " + splitMessage[1] + " " + splitMessage[2] + " " + messagesExample.get(Integer.parseInt(splitMessage[3])).left + " " + splitMessage[4];
        String right = splitMessage[0] + " " + splitMessage[1] + " " + splitMessage[2] + " " + messagesExample.get(Integer.parseInt(splitMessage[3])).right + " " + splitMessage[4];
        stack.add(left);
        stack.add(right);
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
        testMethod2(stack.pop());
        testPrintStack();
        testMethod2(stack.pop());
        testMethod2(stack.pop());
        testMethod3(stack.pop());
        testMethod3(stack.pop());
        testMethod3(stack.pop());
//        testMethod3(stack.pop());
//        testPrintStack();
    }
    
    public void testPrintStack() {
        for (String s : stack) {
            System.out.println(s);
        }
    }

    public void printMessages() {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println("Index: " + i + " Left message: " + messages.get(i).left + " Right message: " + messages.get(i).right);
        }
    }

}
