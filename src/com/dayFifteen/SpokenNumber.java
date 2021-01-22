package com.dayFifteen;

public class SpokenNumber {

    private int number;
    private int previouslySpoken;

    public SpokenNumber(int num, int index) {
        previouslySpoken = index;
        number = num;
    }

    public void setPreviouslySpoken(int previouslySpokenIndex) {
        previouslySpoken = previouslySpokenIndex;
    }

    public int getPreviouslySpoken() {
        return previouslySpoken;
    }
}
