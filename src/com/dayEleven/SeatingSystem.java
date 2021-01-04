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
                System.out.println(seatingPlan.length - 1);
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
                System.out.println("OKAY 3");
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

    public void iterateRounds() {
        int numberOfChanges = 0;

    }

    public void checkNeighbourMethod() {
        seatingPlan[0][2].changeSeatOccupied();
        seatingPlan[0][3].changeSeatOccupied();
        seatingPlan[2][2].changeSeatOccupied();
        printSeatingPlan();
        int i = 1;
        int j = 2;
        System.out.println(checkNeighbouringSeats(i,j));
    }

    public void printSeatAsRows() {
        for (int i = 0; i < seatAsRows.size() ; i++) {
            System.out.println(seatAsRows.get(i));
        }
    }

    public void printSeatingPlan() {
        System.out.println("MAX I " + seatAsRows.size());
        System.out.println("MAX J " + seatAsRows.get(0).length());
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
//                System.out.print("IS SEAT? " + seatingPlan[i][j].getSeatStatus() + " ");
                System.out.print(seatingPlan[i][j].isSeatOccupied() + " ");
            }
            System.out.println("\n");
        }
    }

}
