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
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEleven/seatingArrangements.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEleven/exampleData.txt"
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
                    if (seatingPlan[xCor + 1][yCor].isSeatOccupied()) {
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

    public Seat[][] createCloneOfSeatingPlan() {
         Seat[][] copyOfSeatingPlan = new Seat[seatAsRows.size()][seatAsRows.get(0).length()];
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                Seat seat = new Seat(seatingPlan[i][j].getSeatStatus());
                seat.setSeatOccupied(seatingPlan[i][j].isSeatOccupied());
                copyOfSeatingPlan[i][j] = seat;
            }
        }
         return copyOfSeatingPlan;
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
        int numberOfChanges = 0;
        Seat[][] copyOfSeatingPlan = createCloneOfSeatingPlan();
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                if (!seatingPlan[i][j].isSeatOccupied() && seatingPlan[i][j].getSeatStatus()) {
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

    private int oneIterationPartTwo() {
      int numberOfChanges = 0;
        Seat[][] copyOfSeatingPlan = createCloneOfSeatingPlan();
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
                if (!seatingPlan[i][j].isSeatOccupied() && seatingPlan[i][j].getSeatStatus()) {
                    if (visionCheckForOccupiedChairs(i, j) == 0) {
                        copyOfSeatingPlan[i][j].changeSeatOccupied();
                        numberOfChanges++;
                    }
                } else if (seatingPlan[i][j].isSeatOccupied()){
                    if (visionCheckForOccupiedChairs(i, j) >= 5) {
                        copyOfSeatingPlan[i][j].changeSeatOccupied();
                        numberOfChanges++;
                    }
                }
            }
        }
        seatingPlan = copyOfSeatingPlan;
        return numberOfChanges;
    }

    public void makeIterationsPartTwo() {
        while (oneIterationPartTwo() > 0) {
            oneIterationPartTwo();
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

    private int visionCheckForOccupiedChairs(int x, int y) {
        int numberOfVisibleOccupiedChairs = 0;
        if (checkNorth(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkNorthEast(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkEast(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkSouthEast(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkSouth(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkSouthWest(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkWest(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        if (checkNorthWest(x, y)) {
            numberOfVisibleOccupiedChairs++;
        }
        return numberOfVisibleOccupiedChairs;
    }

    // Todo check if isSeat and occupied. And need to make change such that if come across empty seat first then cant see through it
    private boolean checkNorth(int x, int y) {
        x = x - 1;
        boolean seenChair = false;
        while(x >= 0) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (seatingPlan[x][y].getSeatStatus()) {
                    if (!seatingPlan[x][y].isSeatOccupied()) {
                    } else {
                        seenChair = true;
                    }
                    break;
                }
            }
            x--;
        }
        return seenChair;
    }

    private boolean checkNorthEast(int x, int y) {
        x = x - 1;
        y = y + 1;
        boolean seenChair = false;
        while (x >= 0 && y < seatAsRows.get(0).length()) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            x--;
            y++;
        }
        return seenChair;
    }

    private boolean checkEast(int x, int y) {
        y = y + 1;
        boolean seenChair = false;
        while (y < seatAsRows.get(0).length()) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            y++;
        }
        return seenChair;
    }

    private boolean checkSouthEast(int x, int y) {
        x = x + 1;
        y = y + 1;
        boolean seenChair = false;
        while (x < seatAsRows.size() && y < seatAsRows.get(0).length()) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            x++;
            y++;
        }
        return seenChair;
    }

    private boolean checkSouth(int x, int y) {
        x = x + 1;
        boolean seenChair = false;
        while (x < seatAsRows.size()) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            x++;
        }
        return seenChair;
    }

    private boolean checkSouthWest(int x, int y) {
        x = x + 1;
        y = y - 1;
        boolean seenChair = false;
        while (x < seatAsRows.size() && y >= 0) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            x++;
            y--;
        }
        return seenChair;
    }

    private boolean checkWest(int x, int y) {
        y = y - 1;
        boolean seenChair = false;
        while (y >= 0) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            y--;
        }
        return seenChair;
    }

    private boolean checkNorthWest(int x, int y) {
        x = x - 1;
        y = y - 1;
        boolean seenChair = false;
        while (y >= 0 && x >= 0) {
            if (seatingPlan[x][y].getSeatStatus()) {
                if (!seatingPlan[x][y].isSeatOccupied()) {
                } else {
                    seenChair = true;
                }
                break;
            }
            x--;
            y--;
        }
        return seenChair;
    }

//    public void checkNeighbourMethod() {
//        printSeatingPlan();
//        oneIteration();
//        oneIteration();
//        System.out.println(checkNeighbouringSeats(2, 0));
//        System.out.println(seatingPlan[2][0].isSeatOccupied());
//        printSeatingPlan();
//    }

//    public void printSeatAsRows() {
//        for (int i = 0; i < seatAsRows.size() ; i++) {
//            System.out.println(seatAsRows.get(i));
//        }
//    }

    public void printSeatingPlan() {
        for (int i = 0; i < seatAsRows.size(); i++) {
            for (int j = 0; j < seatAsRows.get(0).length(); j++) {
//                System.out.print(seatingPlan[i][j].getSeatStatus() + " ");
                System.out.print(seatingPlan[i][j].isSeatOccupied() + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

}
