package com.dayFive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardingPasses {

    public List<String> boardingPasses = new ArrayList<>();
    public int[] seatIds = new int[761];

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayFive/BoardingPasses.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    boardingPasses.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private int rowChecker(String binaryCode) {
        int lowerBound = 0;
        int upperBound = 127;
        int row = 0;

        for(int i = 0; i < 6; i++){
            if(binaryCode.charAt(i) == 'F'){
                upperBound = upperBound - (int)Math.pow(2, 6-i);
            } else {
                lowerBound = lowerBound + (int)Math.pow(2, 6-i);
            }
        }
        if(binaryCode.charAt(6) == 'F') {
            row = lowerBound;
        } else {
            row = upperBound;
        }

        return row;
    }

    private int columnChecker(String binaryCode) {
        int lowerBound = 0;
        int upperBound = 7;
        int column = 0;

        for(int i = 7; i < 9; i++){
            if(binaryCode.charAt(i) == 'L'){
                upperBound = upperBound - (int)Math.pow(2, 9-i);
            } else {
                lowerBound = lowerBound + (int)Math.pow(2, 9-i);
            }
        }
        if(binaryCode.charAt(9) == 'L') {
            column = lowerBound;
        } else {
            column = upperBound;
        }

        return column;
    }

    public int highestSeatId(){
        int currentHighestId = 0;
        int i = 0;

        for(String boardingPass : boardingPasses){
            int seatId = rowChecker(boardingPass) * 8 + columnChecker(boardingPass);
            seatIds[i] = seatId;
            if (seatId > currentHighestId) {
                currentHighestId = seatId;
            }
            i++;
        }
        return currentHighestId;
    }

    public int getMissingSeatId() {
        int size = 801;
        int i, total;
        total = size * (size + 1)/2; // Sum of 1 - 801
        total = total - (39 * (39 + 1)/2); // Sum of 40 - 801 (Seat ids)
        System.out.println(total);
        for (i = 0; i < seatIds.length; i++) {
            total -= seatIds[i];
        }
        return total;
    }
}
