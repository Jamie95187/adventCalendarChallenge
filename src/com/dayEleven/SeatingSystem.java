package com.dayEleven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {

    List<String> seatAsRows = new ArrayList<>();
    Seat[][] seatingPlan;

    public SeatingSystem() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEleven/seatingArrangements.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                seatAsRows.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateSeatingPlan() {
        seatingPlan = new Seat[seatAsRows.size()][];
        for(int i = 0; i < seatAsRows.size(); i++) {
            String row = seatAsRows.get(i);
            Seat[] rowOfSeats = new Seat[row.toCharArray().length];
            for (int j = 0; j < row.toCharArray().length; j++) {
                for (Character c : row.toCharArray()) {
                    Seat seat;
                    if(c == '.') {
                        seat = new Seat(false);
                    } else {
                        seat = new Seat(true);
                    }
                    rowOfSeats[j] = seat;
                }
            }
            seatingPlan[i] = rowOfSeats;
        }
    }

    public int checkNeighbouringSeats(int xCor, int yCor) {
        int numberOfOccupiedSeats = 0;
            if (xCor == 0 && yCor == 0) {
                if (seatingPlan[xCor - 1][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor].isSeatOccupied())
            } else {

            }
        return numberOfOccupiedSeats;
    }

}
