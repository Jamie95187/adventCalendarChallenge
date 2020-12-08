package com.daySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BagChecker {

    private List<String> fullListOfRules = new ArrayList<>();
    private List<List<String>> fullListOfBagsOfConcern = new ArrayList<>();
    private Set<String> uniqueContainers = new HashSet<>();

    public void readFile() {
        String txtFile = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeven/bagData.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    txtFile
            ));
            String line = reader.readLine();
            while (line != null){
                if (line != null) {
                    fullListOfRules.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> bagsDirectlyHolding(String bag) {
        List<String> bags = new ArrayList<>();
        for (String rule : fullListOfRules) {
            String container = rule.split(" contain ")[0];
            if (rule.substring(rule.indexOf("contain")).contains(bag) && !uniqueContainers.contains(container)) {
                uniqueContainers.add(container);
                bags.add(container);
            }
        }
        return bags;
    }

    private List<String> bagsDirectlyHold(List<String> bags) {
        List<String> containers = new ArrayList<>();
        for (String bag : bags) {
            bagsDirectlyHolding(bag);
        }
        return containers;
    }

    public void addToSet(){

        // Base case of five bags directly holding shiny gold
        List<String> bagsDirectlyHoldingGold = bagsDirectlyHolding("shiny gold");

        bagsDirectlyHold(bagsDirectlyHoldingGold);

        for (String bag : uniqueBags){
            System.out.println(bag);
        }
    }
}
