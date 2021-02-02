package com.daySixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

public class TicketTranslation {

    List<int[]> rules = new ArrayList<>();
    List<String> nearbyTickets = new ArrayList<>();
    List<String> validNearbyTickets = new ArrayList<>();
    List<Integer> errors = new ArrayList<>();
    Map<Integer, List<String>> indexOfFieldAndValues = new HashMap<Integer, List<String>>();

    private void getRules() {
        try {
//            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Rules.txt";
            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/exampleRulesPartTwo.txt";
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
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Tickets.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/exampleDataPartTwo.txt"
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

    private void populateIndexToValueMap() {
        List<String> zero_index = new ArrayList<String>();
        List<String> one_index = new ArrayList<String>();
        List<String> two_index = new ArrayList<String>();
//        List<String> three_index = new ArrayList<String>();
//        List<String> four_index = new ArrayList<String>();
//        List<String> five_index = new ArrayList<String>();
//        List<String> six_index = new ArrayList<String>();
//        List<String> seven_index = new ArrayList<String>();
//        List<String> eight_index = new ArrayList<String>();
//        List<String> nine_index = new ArrayList<String>();
//        List<String> ten_index = new ArrayList<String>();
//        List<String> eleven_index= new ArrayList<String>();
//        List<String> twelve_index = new ArrayList<String>();
//        List<String> thirteen_index = new ArrayList<String>();
//        List<String> fourteen_index = new ArrayList<String>();
//        List<String> fifteen_index = new ArrayList<String>();
//        List<String> sixteen_index = new ArrayList<String>();
//        List<String> seventeen_index = new ArrayList<String>();
//        List<String> eighteen_index = new ArrayList<String>();
//        List<String> nineteen_index = new ArrayList<String>();
//        List<String> twenty_index = new ArrayList<String>();
        for (int i = 0; i < validNearbyTickets.size(); i++) {
            String[] values = validNearbyTickets.get(i).split(",");
            for(int j = 0; j < values.length; j++) {
                switch(j) {
                    case 0:
                        zero_index.add(values[j]);
                        break;
                    case 1:
                        one_index.add(values[j]);
                        break;
                    case 2:
                        two_index.add(values[j]);
                        break;
//                    case 3:
//                        three_index.add(values[j]);
//                        break;
//                    case 4:
//                        four_index.add(values[j]);
//                        break;
//                    case 5:
//                        five_index.add(values[j]);
//                        break;
//                    case 6:
//                        six_index.add(values[j]);
//                        break;
//                    case 7:
//                        seven_index.add(values[j]);
//                        break;
//                    case 8:
//                        eight_index.add(values[j]);
//                        break;
//                    case 9:
//                        nine_index.add(values[j]);
//                        break;
//                    case 10:
//                        ten_index.add(values[j]);
//                        break;
//                    case 11:
//                        eleven_index.add(values[j]);
//                        break;
//                    case 12:
//                        twelve_index.add(values[j]);
//                        break;
//                    case 13:
//                        thirteen_index.add(values[j]);
//                        break;
//                    case 14:
//                        fourteen_index.add(values[j]);
//                        break;
//                    case 15:
//                        fifteen_index.add(values[j]);
//                        break;
//                    case 16:
//                        sixteen_index.add(values[j]);
//                        break;
//                    case 17:
//                        seventeen_index.add(values[j]);
//                        break;
//                    case 18:
//                        eighteen_index.add(values[j]);
//                        break;
//                    case 19:
//                        nineteen_index.add(values[j]);
//                        break;
//                    case 20:
//                        twenty_index.add(values[j]);
//                        break;
                }
            }
        }
        for (int k = 0; k < 3; k++) {
            switch(k) {
                case 0:
                    indexOfFieldAndValues.put(k, zero_index);
                    break;
                case 1:
                    indexOfFieldAndValues.put(k, one_index);
                    break;
                case 2:
                    indexOfFieldAndValues.put(k, two_index);
                    break;
//                case 3:
//                    indexOfFieldAndValues.put(k, three_index);
//                    break;
//                case 4:
//                    indexOfFieldAndValues.put(k, four_index);
//                    break;
//                case 5:
//                    indexOfFieldAndValues.put(k, six_index);
//                    break;
//                case 6:
//                    indexOfFieldAndValues.put(k, seven_index);
//                    break;
//                case 7:
//                    indexOfFieldAndValues.put(k, eight_index);
//                    break;
//                case 8:
//                    indexOfFieldAndValues.put(k, nine_index);
//                    break;
//                case 9:
//                    indexOfFieldAndValues.put(k, ten_index);
//                    break;
//                case 10:
//                    indexOfFieldAndValues.put(k, eleven_index);
//                    break;
//                case 11:
//                    indexOfFieldAndValues.put(k, twelve_index);
//                    break;
//                case 12:
//                    indexOfFieldAndValues.put(k, thirteen_index);
//                    break;
//                case 13:
//                    indexOfFieldAndValues.put(k, fourteen_index);
//                    break;
//                case 14:
//                    indexOfFieldAndValues.put(k, fifteen_index);
//                    break;
//                case 15:
//                    indexOfFieldAndValues.put(k, sixteen_index);
//                    break;
//                case 16:
//                    indexOfFieldAndValues.put(k, seventeen_index);
//                    break;
//                case 17:
//                    indexOfFieldAndValues.put(k, eighteen_index);
//                    break;
//                case 18:
//                    indexOfFieldAndValues.put(k, nineteen_index);
//                    break;
//                case 19:
//                    indexOfFieldAndValues.put(k, twenty_index);
//                    break;
            }
        }
    }



    private List<Integer> findField(int index){
        List<Integer> rulesVsIndex = new ArrayList<>();
        for (int k = 0; k < rules.size(); k++) {
            Boolean ruleBoolean = true;
            for(int i = 0; i < indexOfFieldAndValues.get(index).size(); i++) {
                int value = Integer.parseInt(indexOfFieldAndValues.get(index).get(i));
                int[] rule = rules.get(k);
                if(value < rule[0] || value > rule[1] && value < rule[2] || value > rule[3]) {
                    if (i == 0) {
                        System.out.println("FALSE FOR " + k);
                    }
                    ruleBoolean = false;
                    break;
                }
                if (!ruleBoolean) {
                    break;
                }
                rulesVsIndex.add(k);
            }
        }
        return rulesVsIndex;
    }

    public void test() {
        getRules();
        getNearbyTickets();
        getErrors();
        populateIndexToValueMap();
        List<Integer> fieldsOfInterest = new ArrayList<>();
        for(int i = 0; i < indexOfFieldAndValues.size(); i++) {
            List<Integer> listOfIndexVsRules = findField(i);
            System.out.println("COLUMN : " + i + " - " + indexOfFieldAndValues.get(i));
            System.out.println("POSSIBLE RULES : " + listOfIndexVsRules);
            System.out.println("  ");
        }
        System.out.println(" ");
//        System.out.println("MAP SIZE : " + indexOfFieldAndValues.size());
//        System.out.println("NEARby TICKETS SIZE " + nearbyTickets.size());
//        System.out.println("VALID NEARBY TICKET SIZE " + validNearbyTickets.size());
//        System.out.println(errors.size());
    }

}
