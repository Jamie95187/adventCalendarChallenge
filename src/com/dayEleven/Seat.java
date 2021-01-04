package com.dayEleven;

public class Seat {

    private boolean isSeat;
    private boolean occupied;

    public Seat(boolean isSeat) {
        this.isSeat = isSeat;
        this.occupied = false;
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
