package com.daySeventeen;

public class Cube {

    boolean active;

    public Cube(int x, int y, int z, boolean state) {
        active = state;
    }

    public boolean getState() {
        return active;
    }

}
