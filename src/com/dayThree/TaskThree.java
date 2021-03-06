package com.dayThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskThree {

    private List<char[]> slope = new ArrayList<>();

    public void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayThree/path.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    slope.add(line.toCharArray());
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int countNumberOfTrees(int right, int down) {
        int treeCount = 0;
        int tobogganPos = 0;
        int rowLength = slope.get(0).length;
        System.out.println("rowLength = " + rowLength);
        for (int i = 0; i < slope.size(); i = i + down) {
            System.out.println("Tree? = " + slope.get(i)[tobogganPos % rowLength]);
            if (slope.get(i)[tobogganPos % rowLength] == '#') {
                treeCount++;
            }
            tobogganPos = tobogganPos + right;
        }
        return treeCount;
    }

}
