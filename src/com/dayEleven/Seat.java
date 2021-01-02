package com.dayEleven;

public class Seat {

    private static boolean isSeat;
    private static boolean occupied;

    public Seat(boolean seatStatus) {
        isSeat = seatStatus;
        occupied = false;
    }

    public void changeSeatOccupied() {
        occupied = !occupied;
    }

    public boolean getSeatStatus() {
        return isSeat;
    }

    public boolean isSeatOccupied() {
        return occupied;
    }
}
