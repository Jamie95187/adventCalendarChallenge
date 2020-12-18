package com.dayNine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Encoding {

    private static List<Long> data = new ArrayList<>();
    private static List<Integer> taskTwoData = new ArrayList<>();

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayNine/data.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                data.add(Long.parseLong(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long findNumber(int n) {
        long number = 0l;
        boolean valid = false;
            for (int i = n; i < n+25; i++) {
                for (int j = n; j < i; j++) {
                    if (data.get(i) + data.get(j) == data.get(n+25)) {
                        valid = true;
                        break;
                    }
                }
                for (int k = n + i; k < n+25; k++) {
                    if (data.get(i) + data.get(k) == data.get(n+25)) {
                        valid = true;
                        break;
                    }
                }
            }
            if (!valid) {
                return data.get(n+25);
            }
        return number;
    }

    public int[] findRange() {
        int lowest = taskTwoData.get(0);
        int highest = taskTwoData.get(taskTwoData.size() - 1);
        int sum = 0;

        for (int i = taskTwoData.size() - 1; i >= 0; i--) {
            highest = taskTwoData.get(i);
            sum = highest;
            for (int j = i-1; j >= 0; j--) {
                sum += taskTwoData.get(j);
                if (sum == 14360655){
                    lowest = taskTwoData.get(j);
                    System.out.println("henlo!");
                    break;
                } else if (sum > 14360655){
                    sum = 0;
                }
            }
            if (sum == 14360655) {
                break;
            }
        }

        int[] answer = new int[2];
        answer[0] = lowest;
        answer[1] = highest;
        return answer;
    }

    public void printAnswer(){
        for(int index = 0; index < data.size() - 26; index++) {
            if (findNumber(index) > 0L) {
                System.out.println(findNumber(index));
            }
        }
    }

    public void printData() {
        for (Long input : data){
            System.out.println(input);
        }
    }

    private void reduceRange() {
        for (Long number: data) {
            if (number < 14360655) {
                taskTwoData.add((int) (long) number);
            }
        }
    }

    public void printDataTwo() {
        reduceRange();
        for (int n : taskTwoData) {
            System.out.println(n);
        }
    }
}
