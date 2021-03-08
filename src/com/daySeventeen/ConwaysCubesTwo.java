package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubesTwo {

    Cube[][][] grid;

    // For example grid
    int xMax = 5;
    int yMax = 5;
    int zMax = 2;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/exampleGrid.txt"
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
                        grid[xCounter][yCounter][0] = new Cube(true);
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

    public int countZPlane(int x, int y, int z) {
        int activeCubes = 0;
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public int countZPlusOnePlane(int x, int y, int z) {
        int activeCubes = 0;
        if (grid[x][y][z+1].getState()) {
            activeCubes++;
        }
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public int countZMinusOnePlane(int x, int y, int z) {
        int activeCubes = 0;
        if (grid[x][y][z-1].getState()) {
            activeCubes++;
        }
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public void oneGeneration() {
        Cube[][][] newGrid = new Cube[xMax+3][yMax+3][zMax+2];
        for (int x = 0 ; x <= xMax+2; x++) {
            for (int y = 0 ; y <= yMax+2; y++) {
                for (int z = 0; z <= zMax+1; z++) {
                    newGrid[x][y][z] = new Cube(false);
                }
            }
        }

        // z = 0 plane where we consider count z+1 plane twice

        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                if (!grid[x][y][0].getState()) {
                    if (countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 3) {
                        newGrid[x+1][y+1][0] = new Cube(true);
                    }
                } else {
                    if (countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 3 || countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 2) {
                        newGrid[x+1][y+1][0] = new Cube(true);
                    }
                }
            }
        }

        // Where z != 0

        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 1; z < zMax; z++) {
                    if (!grid[x][y][z].getState()) {
                        if (countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZMinusOnePlane(x, y, z) == 3) {
                            newGrid[x+1][y+1][z] = new Cube(true);
                        }
                    } else {
                        if (countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZPlusOnePlane(x, y, z) == 3 || countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZPlusOnePlane(x, y, z) == 2) {
                            newGrid[x+1][y+1][z] = new Cube(true);
                        }
                    }
                }
            }
        }

        grid = newGrid;

        xMax = xMax + 2;
        yMax = yMax + 2;
        zMax = zMax + 1;

    }

    private int countActiveCubes() {
        int activeCubes = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                if (grid[x][y][0].getState()) {
                    activeCubes++;
                }
            }
        }
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 1; z <= zMax; z++) {
                    if (grid[x][y][z].getState()) {
                        activeCubes++;
                        activeCubes++;
                    }
                }
            }
        }
        return activeCubes;
    }

    public void test() {
        readInitialGrid();
        System.out.println(countActiveCubes());
//        for (int z = 0; z <= zMax; z++) {
//            System.out.println("Z plane = " + z);
//            for (int x = 0; x <= xMax; x++) {
//                for (int y = 0; y <= yMax; y++) {
//                    System.out.println("X = " + x + ", Y = " + y + ", STATE = " + grid[x][y][z].getState());
//                }
//            }
//        }
        oneGeneration();
        oneGeneration();
//        for (int z = 0; z <= zMax; z++) {
//            System.out.println("Z plane = " + z);
//            for (int x = 0; x <= xMax; x++) {
//                for (int y = 0; y <= yMax; y++) {
//                    System.out.println("X = " + x + ", Y = " + y + ", STATE = " + grid[x][y][z].getState());
//                }
//            }
//        }
        System.out.println(countActiveCubes());
    }
}
