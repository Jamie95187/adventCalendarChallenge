package com.dayFifteen;

public class SpokenNumber {

    private int number;
    private int previouslySpoken;
    private int mostRecentlySpoken;

    public SpokenNumber(int num, int previous) {
        previouslySpoken = previous;
        number = num;
    }

    public void setPreviouslySpoken(int previouslySpokenIndex) {
        previouslySpoken = previouslySpokenIndex;
    }

    public void setMostRecentlySpoken(int recentlySpokenIndex) {
        mostRecentlySpoken = recentlySpokenIndex;
    }

    public int getMostRecentlySpoken() {
        return mostRecentlySpoken;
    }

    public int getPreviouslySpoken(){
        return previouslySpoken;
    }

}
