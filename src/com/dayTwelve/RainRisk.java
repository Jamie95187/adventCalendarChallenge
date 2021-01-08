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
    private int currentDirectionOfWaypoint = 0;
    private int waypointNorth = 1;
    private int wayPointEast = 10;
    private int wayPointSouth = 0;
    private int wayPointWest = 0;
//    private Map<String, Integer> waypointPositionRelativeToCompass;
//    {
//        waypointPositionRelativeToCompass = new HashMap<>();
//        waypointPositionRelativeToCompass.put("East", 10);
//        waypointPositionRelativeToCompass.put("South", 0);
//        waypointPositionRelativeToCompass.put("West", 0);
//        waypointPositionRelativeToCompass.put("North", 1);
//    }
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
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwelve/NavigationInstructions.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayTwelve/exampleNavigationInstructions.txt"
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

    private void changeDirectionOfWayPoint(String[] instruction) {
        int degrees = Integer.parseInt(instruction[1]) % 360;
        if (instruction[0].contains("R")) {
            updateWaypointClockWise((currentDirectionOfWaypoint + (degrees/90)) % 4);
            currentDirectionOfWaypoint = (currentDirectionOfWaypoint + (degrees/90)) % 4;
        } else {
            updateWaypointAntiClockWise((4 + currentDirectionOfWaypoint - (degrees/90)) % 4);
            currentDirectionOfWaypoint = (4 + currentDirectionOfWaypoint - (degrees/90)) % 4;
        }
    }

    private void updateWaypointClockWise(int clockwiseTurn) {
        int eastValue = wayPointEast;
        int southValue = wayPointSouth;
        int westValue = wayPointWest;
        int northValue = waypointNorth;
        if (clockwiseTurn == 1) {
            wayPointEast = northValue;
            wayPointSouth = eastValue;
            wayPointWest = southValue;
            waypointNorth = westValue;
//            waypointPositionRelativeToCompass.put("East", northValue);
//            waypointPositionRelativeToCompass.put("South", eastValue);
//            waypointPositionRelativeToCompass.put("West", southValue);
//            waypointPositionRelativeToCompass.put("North", westValue);
        } else if (clockwiseTurn == 2) {
            wayPointEast = westValue;
            wayPointSouth = northValue;
            wayPointWest = eastValue;
            waypointNorth = southValue;
//            waypointPositionRelativeToCompass.put("East", westValue);
//            waypointPositionRelativeToCompass.put("South", northValue);
//            waypointPositionRelativeToCompass.put("West", eastValue);
//            waypointPositionRelativeToCompass.put("North", southValue);
        } else {
            wayPointEast = southValue;
            wayPointSouth = westValue;
            wayPointWest = northValue;
            waypointNorth = eastValue;
//            waypointPositionRelativeToCompass.put("East", southValue);
//            waypointPositionRelativeToCompass.put("South", westValue);
//            waypointPositionRelativeToCompass.put("West", northValue);
//            waypointPositionRelativeToCompass.put("North", eastValue);
        }
    }

    private void updateWaypointAntiClockWise(int antiClockwiseTurn) {
        int eastValue = wayPointEast;
        int southValue = wayPointSouth;
        int westValue = wayPointWest;
        int northValue = waypointNorth;
//        int eastValue = waypointPositionRelativeToCompass.get("East");
//        int southValue = waypointPositionRelativeToCompass.get("South");
//        int westValue = waypointPositionRelativeToCompass.get("West");
//        int northValue = waypointPositionRelativeToCompass.get("North");
        if (antiClockwiseTurn == 1) {
            wayPointEast = southValue;
            wayPointSouth = westValue;
            wayPointWest = northValue;
            waypointNorth = eastValue;
//            waypointPositionRelativeToCompass.put("East", southValue);
//            waypointPositionRelativeToCompass.put("South", westValue);
//            waypointPositionRelativeToCompass.put("West", northValue);
//            waypointPositionRelativeToCompass.put("North", eastValue);
        } else if (antiClockwiseTurn == 2) {
            wayPointEast = westValue;
            wayPointSouth = northValue;
            wayPointWest = eastValue;
            waypointNorth = southValue;
//            waypointPositionRelativeToCompass.put("East", westValue);
//            waypointPositionRelativeToCompass.put("South", northValue);
//            waypointPositionRelativeToCompass.put("West", eastValue);
//            waypointPositionRelativeToCompass.put("North", southValue);
        } else {
            wayPointEast = northValue;
            wayPointSouth = eastValue;
            wayPointWest = southValue;
            waypointNorth = westValue;
//            waypointPositionRelativeToCompass.put("East", northValue);
//            waypointPositionRelativeToCompass.put("South", eastValue);
//            waypointPositionRelativeToCompass.put("West", southValue);
//            waypointPositionRelativeToCompass.put("North", westValue);
        }
    }

    private void oneActionPartTwo(String[] instruction) {
        String action = instruction[0];
        int value = Integer.parseInt(instruction[1]);
        if (action.contains("R") || action.contains("L")) {
            changeDirectionOfWayPoint(instruction);
        } else if (action.contains("N")) {
            waypointNorth += value;
        } else if (action.contains("E")) {
            wayPointEast += value;
        } else if (action.contains("S")) {
            wayPointSouth += value;
        } else if (action.contains("W")) {
            wayPointWest += value;
        } else {
            north += waypointNorth * value;
            east += wayPointEast * value;
            west += wayPointWest * value;
            south += wayPointSouth * value;
        }
    }

    public void multipleActionsPartTwo() {
        for (int i = 0; i < instructions.size(); i++) {
            oneActionPartTwo(instructions.get(i));
        }
        System.out.println("EAST : " + east);
        System.out.println("WEST : " + west);
        System.out.println("SOUTH : " + south);
        System.out.println("NORTH : " + north);
        System.out.println(Math.abs(east - west) + Math.abs(south - north));
    }
}
