package com.dayThirteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShuttleSearch {

    private int timestampDeparture;
    private String busTimeTable;
    private List<String> busIdsPartTwo = new ArrayList<String>();
    private List<Integer> busIds = new ArrayList<Integer>();
    private List<Integer> waitTime = new ArrayList<Integer>();
    private List<int[]> equations = new ArrayList();

    public ShuttleSearch() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThirteen/BusTimetable.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThirteen/exampleTimetable.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThirteen/exampleTimetablePartTwo.txt"
            ));
            String line = reader.readLine();
            timestampDeparture = Integer.parseInt(line);
            line = reader.readLine();
            busTimeTable = line;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateBusIdsList() {
        String[] arrayOfBusIds = busTimeTable.split(",");
        for (int i = 0; i < arrayOfBusIds.length; i++) {
            if(!arrayOfBusIds[i].contains("x")) {
                busIds.add(Integer.parseInt(arrayOfBusIds[i]));
            }
        }
    }

    private void populateWaitTimeArrayList() {
        for (int i = 0; i < busIds.size(); i++) {
            int waitTimeForBus = ((timestampDeparture/busIds.get(i)) + 1) * busIds.get(i) - timestampDeparture;
            System.out.println("WAIT TIME FOR BUS : " + waitTimeForBus);
            waitTime.add(waitTimeForBus);
        }
    }

    private void populateBusIdsListWithXs() {
        String[] arrayOfBusIds = busTimeTable.split(",");
        for (int i = 0; i < arrayOfBusIds.length; i++) {
            busIdsPartTwo.add(arrayOfBusIds[i]);
        }
    }

    public void fineShortestWait() {
        populateBusIdsList();
        populateWaitTimeArrayList();
        int shortestWaitTime = waitTime.get(0);
        int indexOfShortestWaitTime = 0;
        for (int i = 0; i < waitTime.size(); i++) {
            if (shortestWaitTime > waitTime.get(i)) {
                shortestWaitTime = waitTime.get(i);
                indexOfShortestWaitTime = i;
            }
        }

        System.out.println(busIds.get(indexOfShortestWaitTime) * waitTime.get(indexOfShortestWaitTime));
    }

    // Example timetable part two 7,13,x,x,59,x,31,19
    // solve for
    //          t % 7 = 0
    //          t % 13 = 12
    //          t % 59 = 55
    //          t % 31 = 25
    //          t % 19 = 0
    // Need to learn how to find modulo inverse

    public void chineseRemainderTheorem() {
        populateBusIdsListWithXs();
        populateListOfEquations();
        int sum = 0;
        int productOfModuli = 1;
        for (int i = 0; i < equations.size(); i++) {
            sum += equations.get(i)[0] * findValueOfMi(i) * findValueOfMiPrime(i);
            productOfModuli = productOfModuli * equations.get(i)[1];
        }
        int answer;
        answer = sum % productOfModuli;
//        System.out.println("SUM : " + sum);
//        System.out.println("PRODUCT OF MODULI : " + productOfModuli);
        System.out.println(answer);
    }

    private void populateListOfEquations() {
        for(int i = 0; i < busIdsPartTwo.size(); i++) {
            if(!busIdsPartTwo.get(i).contains("x"))
            equations.add(equationSetup(i));
        }
    }

    private int findValueOfMi(int i) {
        int productOfModuli = 1;
        int Mi;
        for(int k = 0; k < equations.size(); k++) {
            productOfModuli = productOfModuli * equations.get(k)[1];
        }
        Mi = productOfModuli / equations.get(i)[1];
        return Mi;
    }

    private int findValueOfMiPrime(int i) {
        int mi = equations.get(i)[1];
        int inverseMi = 0;
        for(int k = 0; k < mi; k++) {
            if ((k * findValueOfMi(i)) % mi == 1) {
                inverseMi = k;
            }
        }
        return inverseMi % mi;
    }

    private int[] equationSetup(int index) {
        int[] equationValues = new int[2];
        equationValues[1] = Integer.parseInt(busIdsPartTwo.get(index));
        equationValues[0] = (Integer.parseInt(busIdsPartTwo.get(index)) - index) % Integer.parseInt(busIdsPartTwo.get(index));
        return equationValues;
    }
}
