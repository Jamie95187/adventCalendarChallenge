package com.dayone;

//--- Day 1: Report Repair ---
//
//        After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.
//
//        The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars.
//        None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on
//        your room.
//
//        To save your vacation, you need to get all fifty stars by December 25th.
//
//        Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first.
//        Each puzzle grants one star. Good luck!
//
//        Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.
//        Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
//        For example, suppose your expense report contained the following:
//
//        1721
//        979
//        366
//        299
//        675
//        1456
//
//        In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskOne {

    private List<Integer> data = new ArrayList<>();

    public void readFile() {
        String csvFile = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayone/data.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] values = input.split(",");
                for (String entry: values) {
                    data.add(Integer.parseInt(entry));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(data);
    }

    private int reduce (ArrayList<Integer> dataSet) {
        int ans = 0;
        int firstNum = dataSet.get(0);
        int lastNum;
        int i = dataSet.size() - 1;
        while (firstNum + dataSet.get(i) > 2020) {
            i--;
        }
        if (firstNum + dataSet.get(i) == 2020) {
            ans = (firstNum * dataSet.get(i));
            System.out.println(ans);
        } else {
            dataSet = new ArrayList<Integer>(dataSet.subList(1, i));
            reduce(dataSet);
        }
        return ans;
    }

    private int reduceForThree (ArrayList<Integer> dataSet) {
        ArrayList<Integer> dataSetCopy = dataSet;
        int ans = 0;
        int highestPossibleIndexAfterFirstLoop = dataSet.size() - 1;
        int firstNum = dataSet.get(0);
        int j = 1;
        int secondNum = dataSet.get(j);
        int sumOfTwo = 2020 - firstNum;
        int highestPossibleIndex = dataSet.size() - 1;
        int i = dataSetCopy.size() - 1;
        while (j < i) {
            i = dataSetCopy.size() - 1;
            secondNum = dataSetCopy.get(j);
            while (i > j) {
                if (secondNum + dataSetCopy.get(i) > sumOfTwo) {
                    i--;
                } else if (secondNum + dataSetCopy.get(i) == sumOfTwo) {
                    ans = firstNum * secondNum * dataSetCopy.get(i);
                    System.out.println(ans);
                    return ans;
                } else {
                    highestPossibleIndex = i;
                    break;
                }
            }
            dataSetCopy = new ArrayList<Integer>(dataSetCopy.subList(0, highestPossibleIndex + 1));
            if (j == 1) {
                highestPossibleIndexAfterFirstLoop = highestPossibleIndex;
            }
            j++;
        }
        dataSet = new ArrayList<Integer>(dataSet.subList(1, highestPossibleIndexAfterFirstLoop));
        if (ans == 0) {
            reduceForThree(dataSet);
        }
        return ans;
    }

    public void printAnswerOne () {
        System.out.println(reduce((ArrayList<Integer>) data));
    }

    public void printAnswerTwo() {
        System.out.println(reduceForThree((ArrayList<Integer>) data));
    }

    public void printData () {
        for(Integer entry: data) {
            System.out.println(entry);
        }
    }

}
