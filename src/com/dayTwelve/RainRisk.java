package com.dayTwelve;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RainRisk {

    LinkedList<String[]> instructions = new LinkedList<>();
    private static Map<Integer, String> directionHashMap;
    static {
        directionHashMap = new HashMap<>();
        directionHashMap.put(0, "East");
        directionHashMap.put(1, "South");
        directionHashMap.put(2, "West");
        directionHashMap.put(3, "North");
    }
    private int currentDirection;
    private int north = 0;
    private int east = 0;
    private int south = 0;
    private int west = 0;

    public RainRisk() {
        currentDirection = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwelve/NavigationInstructions.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwelve/exampleNavigationInstructions.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                String action = line.substring(0, 1);
                String value = line.substring(1);
                String[] instruction = new String[2];
                instruction[0] = action;
                instruction[1] = value;
                instructions.add(instruction);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeDirection(String[] instruction) {
        int degrees = Integer.parseInt(instruction[1]) % 360;
        if (instruction[0].contains("R")) {
            currentDirection = (currentDirection + (degrees/90)) % 4;
        } else {
            currentDirection = (4 + currentDirection - (degrees/90)) % 4;
        }
    }

    private void oneInstruction(String[] instruction) {
        String action = instruction[0];
        System.out.println(action);
        int value = Integer.parseInt(instruction[1]);
        if (action.contains("R") || action.contains("L")) {
            changeDirection(instruction);
        } else if (action.contains("F")) {
            if (currentDirection == 0) {
                east += value;
            } else if (currentDirection == 1) {
                south += value;
            } else if (currentDirection == 2) {
                west += value;
            } else {
                north += value;
            }
        } else {
            if (action.contains("E")) {
                east += value;
            } else if (action.contains("S")) {
                south += value;
            } else if (action.contains("W")) {
                west += value;
            } else {
                north += value;
            }
        }
    }

    public void makeMultipleInstructions () {
        for (int i = 0; i < instructions.size(); i++) {
            oneInstruction(instructions.get(i));
        }
        System.out.println("EAST : " + east);
        System.out.println("WEST : " + west);
        System.out.println("SOUTH : " + south);
        System.out.println("NORTH : " + north);
        System.out.println(Math.abs(east - west) + Math.abs(south - north));
    }
}
