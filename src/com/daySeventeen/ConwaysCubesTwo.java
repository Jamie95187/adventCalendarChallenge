package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubesTwo {

    Cube[][][] grid;

    // For example grid
    int xMax = 2;
    int yMax = 2;
    int zMax = 1;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/exampleGrid.txt"
            ));
            grid = new Cube[xMax+1][yMax+1][zMax+1];
            // Initially fill grid with inactive cubes
            for (int x = 0 ; x <= xMax; x++) {
                for (int y = 0 ; y <= yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        grid[x][y][z] = new Cube(false);
                    }
                }
            }
            String line = reader.readLine();
            int yCounter = 1;
            while(line != null) {
                char[] charArray = line.toCharArray();
                int xCounter = 1;
                for (char c : charArray) {
                    if (c == '#') {
                        grid[xCounter][yCounter][1] = new Cube(true);
                    }
                    xCounter++;
                }
                line = reader.readLine();
                yCounter++;
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void checkSymmetryLinePlane() {
        
    }

}
