package com.dayThirteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShuttleSearch {

    private int timestampDeparture;
    private String busTimeTable;
    private List<Integer> busIds = new ArrayList<Integer>();
    private List<Integer> waitTime = new ArrayList<Integer>();

    public ShuttleSearch() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThirteen/BusTimetable.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThirteen/exampleTimetable.txt"
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

    public void chineseRemainder(int a, int b) {
        
    }
}
