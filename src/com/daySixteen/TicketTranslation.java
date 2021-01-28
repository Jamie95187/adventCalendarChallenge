package com.daySixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class TicketTranslation {

    List<int[]> rules = new ArrayList<>();
    List<String> nearbyTickets = new ArrayList<>();
    List<String> validNearbyTickets = new ArrayList<>();
    List<Integer> errors = new ArrayList<>();

    private void getRules() {
        try {
            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Rules.txt";
//            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/exampleRules.txt";
            String content = Files.readString(Paths.get(path), StandardCharsets.US_ASCII);
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(content);
            while (m.find()) {
                int[] rule = new int[4];
                rule[0] = Integer.parseInt(m.group());
                m.find();
                rule[1] = Integer.parseInt(m.group());
                m.find();
                rule[2] = Integer.parseInt(m.group());
                m.find();
                rule[3] = Integer.parseInt(m.group());
                rules.add(rule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getNearbyTickets() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Tickets.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/exampleData.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                nearbyTickets.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getErrors() {
        int errorCount = 0;
        for (int i = 0; i < nearbyTickets.size(); i++) {
            boolean validTicket = true;
            String[] values = nearbyTickets.get(i).split(",");
            for (int j = 0; j < values.length; j++) {
                int value = Integer.parseInt(values[j]);
                boolean validValue = false;
                for (int k = 0; k < rules.size(); k++) {
//                    System.out.println("VALUE " + value);
//                    System.out.println("FIRST LOWER BOUND : " + rules.get(k)[0] +  " FIRST UPPER BOUND : " + rules.get(k)[1]);
//                    System.out.println("SECOND LOWER BOUND : " + rules.get(k)[2] +  " SECOND UPPER BOUND : " + rules.get(k)[3]);
                    if (rules.get(k)[0] <= value && rules.get(k)[1] >= value || rules.get(k)[2] <= value && rules.get(k)[3] >= value) {
                        validValue = true;
                        break;
                    }
                }
                if (!validValue) {
                    validTicket = false;
                    errors.add(value);
                    errorCount += value;
                }
            }
            if (validTicket) {
                validNearbyTickets.add(nearbyTickets.get(i));
            }
        }
        System.out.println("error Count : " + errorCount);
    }

    private List<String> copyNearbyTickets() {
        List<String> copyOfNearbyTickets = new ArrayList<>();
        for(int i = 0; i < nearbyTickets.size(); i++) {
            copyOfNearbyTickets.add(nearbyTickets.get(i));
        }
        return copyOfNearbyTickets;
    }

    public void test() {
        getRules();
        getNearbyTickets();
        getErrors();
        System.out.println("NEARby TICKETS SIZE " + nearbyTickets.size());
        System.out.println("VALID NEARBY TICKET SIZE " + validNearbyTickets.size());
        System.out.println(errors.size());
    }

}
