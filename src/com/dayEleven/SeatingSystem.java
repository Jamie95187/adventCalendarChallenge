package com.dayEleven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatingSystem {

    List<String> seatAsRows = new ArrayList<>();
    Seat[][] seatingPlan;

    public SeatingSystem() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEleven/seatingArrangements.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEleven/exampleData.txt"
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
        seatingPlan = new Seat[seatAsRows.size()][seatAsRows.get(0).length()];
        for(int i = 0; i < seatAsRows.size(); i++) {
            String row = seatAsRows.get(i);
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                Seat seat;
                if(row.charAt(j) == '.') {
                    seat = new Seat(false);
                } else {
                    seat = new Seat(true);
                }
                seatingPlan[i][j] = seat;
            }
        }
    }

    public int checkNeighbouringSeats(int xCor, int yCor) {
        int numberOfOccupiedSeats = 0;
            if (xCor == 0) {
                if (yCor == 0) {
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                } else if (yCor == seatAsRows.get(0).length() - 1) {
                    if (seatingPlan[xCor][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor -1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                } else {
                    if (seatingPlan[xCor][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                }
            } else if (yCor == 0){
                if (xCor == seatingPlan.length - 1) {
                    if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                } else {
                    if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor + 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                }
            } else if (xCor == seatingPlan.length - 1) {
                if (yCor == seatAsRows.get(0).length() - 1) {
                    if (seatingPlan[xCor][yCor - 1].isSeatOccupied()){
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                }
                else {
                    if (seatingPlan[xCor][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor - 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor - 1][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                    if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                        numberOfOccupiedSeats++;
                    }
                }
            } else if (yCor == seatAsRows.get(0).length() - 1){
                if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor + 1][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
            } else {
                if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor + 1][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor - 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor - 1][yCor + 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor][yCor + 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
                if (seatingPlan[xCor + 1][yCor + 1].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
            }
        return numberOfOccupiedSeats;
    }

    public void makeIterations() {
        while (oneIteration() > 0) {
            oneIteration();
        }
        int numberOfOccupiedSeats = 0;
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                if (seatingPlan[i][j].isSeatOccupied()) {
                    numberOfOccupiedSeats++;
                }
            }
        }
        System.out.println(numberOfOccupiedSeats);
    }

    private int oneIteration() {
        printSeatingPlan();
        int numberOfChanges = 0;
        Seat[][] copyOfSeatingPlan = seatingPlan;
        System.out.println(" 0 3 NEIGHBOURS = " + checkNeighbouringSeats(0, 3));
        System.out.println(" 0 3 IS IT A SEAT " + seatingPlan[0][3].getSeatStatus());
        System.out.println(" 0 3 IS SEAT OCCUPIED " + seatingPlan[0][3].isSeatOccupied());
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                if (!seatingPlan[i][j].isSeatOccupied() && seatingPlan[i][j].getSeatStatus()) {
                    if (i == 0 && j == 3) {
                        System.out.println("YESSS!");
                        System.out.println(" 0 3 NEIGHBOURS = " + checkNeighbouringSeats(0, 3));
                    }
                    if (checkNeighbouringSeats(i, j) == 0) {
                        copyOfSeatingPlan[i][j].changeSeatOccupied();
                        numberOfChanges++;
                    }
                } else if (seatingPlan[i][j].isSeatOccupied()){
                    if (checkNeighbouringSeats(i, j) >= 4) {
                        copyOfSeatingPlan[i][j].changeSeatOccupied();
                        numberOfChanges++;
                    }
                }
            }
        }
        seatingPlan = copyOfSeatingPlan;
        return numberOfChanges;
    }

    public void checkNeighbourMethod() {
        printSeatingPlan();
        System.out.println(checkNeighbouringSeats(0,0));
        System.out.println(checkNeighbouringSeats(0,3));
        oneIteration();
        printSeatingPlan();
    }

    public void printSeatAsRows() {
        for (int i = 0; i < seatAsRows.size() ; i++) {
            System.out.println(seatAsRows.get(i));
        }
    }

    public void printSeatingPlan() {
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
//                System.out.print(seatingPlan[i][j].getSeatStatus() + " ");
                System.out.print("iCor : " + i + " jCor : " + j  +" "  + seatingPlan[i][j].isSeatOccupied() + " ");
            }
            System.out.println("\n");
        }
    }

}
