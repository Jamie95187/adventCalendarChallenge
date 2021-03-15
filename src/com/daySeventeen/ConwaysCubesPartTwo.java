package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubesPartTwo {
    Cube[][][][] grid;

//     For example grid
    int xMax = 4;
    int yMax = 4;
    int zMax = 2;
    int wMax = 2;

//    int xMax = 10;
//    int yMax = 10;
//    int zMax = 2;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/exampleGrid.txt"
            ));
            grid = new Cube[xMax+1][yMax+1][zMax+1][wMax+1];
            // Initially fill grid with inactive cubes
            for (int x = 0 ; x <= xMax; x++) {
                for (int y = 0 ; y <= yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        for (int w = 0; w <= wMax; w++) {
                            grid[x][y][z][w] = new Cube(false);
                        }
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
                        grid[xCounter][yCounter][1][0] = new Cube(true);
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

    public int countWMinusPlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        activeCubes = countWPlane(x,y,z,w-1);
        return activeCubes;
    }

    public int countWPlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        activeCubes = countZPlane(x,y,z,w) + countZMinusOnePlane(x,y,z,w) + countZPlusOnePlane(x,y,z,w);
        return activeCubes;
    }

    public int countWPlusOne(int x, int y, int z, int w) {
        int activeCubes = 0;
        activeCubes = countWPlane(x,y,z,w+1);
        return activeCubes;
    }

    public int countZPlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        if (w != 0) {
            if (grid[x][y][z][w].getState()) {
                activeCubes++;
            }
        }
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z][w].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public int countZPlusOnePlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        if (grid[x][y][z+1][w].getState()) {
            activeCubes++;
        }
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z+1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z+1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z+1][w].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public int countZMinusOnePlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        if (grid[x][y][z-1][w].getState()) {
            activeCubes++;
        }
        if (x == 0) {
            if (y == 0) {
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x != 0 && x != xMax) {
            if (y == 0) {
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax){
                if (grid[x-1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x+1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
            }
        } else if (x == xMax){
            if (y == 0) {
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y != 0 && y != yMax) {
                if (grid[x-1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y+1][z-1][w].getState()) {
                    activeCubes++;
                }
            } else if (y == yMax) {
                if (grid[x-1][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x][y-1][z-1][w].getState()) {
                    activeCubes++;
                }
                if (grid[x-1][y][z-1][w].getState()) {
                    activeCubes++;
                }
            }
        }
        return activeCubes;
    }

    public void oneGeneration() {
        Cube[][][][] newGrid = new Cube[xMax+3][yMax+3][zMax+2][wMax+2];
        for (int x = 0 ; x <= xMax+2; x++) {
            for (int y = 0 ; y <= yMax+2; y++) {
                for (int z = 0; z <= zMax+1; z++) {
                    for (int w = 0; w <= wMax+1; w++) {
                        newGrid[x][y][z][w] = new Cube(false);
                    }
                }
            }
        }

        // w = 0 where we count w+1 twice

        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z <= zMax; y++) {
                    if (!grid[x][y][z][0].getState()) {
                        if (countWPlane(x,y,z,0) + countWPlusOne(x,y,z,0) + countWPlusOne(x,y,z,0) == 3) {
                            newGrid[x+1][y+1][z+1][0] = new Cube(true);
                        }
                    } else {
                        if (countWPlane(x,y,z,0) + countWPlusOne(x,y,z,0) + countWPlusOne(x,y,z,0) == 3 || countWPlane(x,y,z,0) + countWPlusOne(x,y,z,0) + countWPlusOne(x,y,z,0) == 2) {
                            newGrid[x+1][y+1][z+1][0] = new Cube(true);
                        }
                    }
                }
            }
        }

        // Where w != 0

        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z <= zMax; z++) {
                    for (int w = 1; w < wMax; w++) {
                        if (!grid[x][y][z][w].getState()) {
                            if (countWPlane(x, y, z, w) + countWPlusOne(x, y, z, w) + countWPlusOne(x, y, z, w) == 3) {
                                newGrid[x+1][y+1][z+1][w] = new Cube(true);
                            }
                        } else if (grid[x][y][z][w].getState()) {
                            if (countWPlane(x, y, z, w) + countWPlusOne(x, y, z, w) + countWMinusPlane(x, y, z, w) == 3 || countWPlane(x, y, z, w) + countWPlusOne(x, y, z, w) + countWMinusPlane(x, y, z, w) == 2) {
                                newGrid[x+1][y+1][z+1][w] = new Cube(true);
                            }
                        }
                    }

                }
            }
        }

        // z = 0 plane where we consider count z+1 plane twice

//        for (int x = 0; x <= xMax; x++) {
//            for (int y = 0; y <= yMax; y++) {
//                if (!grid[x][y][0].getState()) {
//                    if (countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 3) {
//                        newGrid[x+1][y+1][0] = new Cube(true);
//                    }
//                } else {
//                    if (countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 3 || countZPlane(x, y,0) + countZPlusOnePlane(x, y,0) + countZPlusOnePlane(x, y,0) == 2) {
//                        newGrid[x+1][y+1][0] = new Cube(true);
//                    }
//                }
//            }
//        }

        // Where z != 0

//        for (int x = 0; x <= xMax; x++) {
//            for (int y = 0; y <= yMax; y++) {
//                for (int z = 1; z < zMax; z++) {
//                    if (!grid[x][y][z].getState()) {
//                        if (countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZMinusOnePlane(x, y, z) == 3) {
//                            newGrid[x+1][y+1][z] = new Cube(true);
//                        }
//                    } else if (grid[x][y][z].getState()) {
//                        if (countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZMinusOnePlane(x, y, z) == 3 || countZPlane(x, y, z) + countZPlusOnePlane(x, y, z) + countZMinusOnePlane(x, y, z) == 2) {
//                            newGrid[x+1][y+1][z] = new Cube(true);
//                        }
//                    }
//                }
//            }
//        }

        grid = newGrid;

        xMax = xMax + 2;
        yMax = yMax + 2;
        zMax = zMax + 1;
        wMax = wMax + 1;

    }

    private int countActiveCubes() {
        int activeCubes = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z <= zMax; z++) {
                    if (grid[x][y][z][0].getState()) {
                        activeCubes++;
                    }
                }
            }
        }
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z <= zMax; z++) {
                    for (int w = 1; w < wMax; w++) {
                        if (grid[x][y][z][w].getState()) {
                            activeCubes++;
                            activeCubes++;
                        }
                    }
                }
            }
        }
        return activeCubes;
    }

    public void test() {
        readInitialGrid();
//        printGrid();
        oneGeneration();
        printGrid();
    }

    public void printGrid() {
        for (int w = 0; w <= wMax; w++) {
            System.out.println("W plane = " + w);
            for (int z = 0; z <= zMax; z++) {
                System.out.println("Z plane = " + z);
                for (int x = 0; x <= xMax; x++) {
                    for (int y = 0; y <= yMax; y++) {
                        System.out.println("X = " + x + ", Y = " + y + ", STATE = " + grid[x][y][z][w].getState());
                    }
                }
            }
        }
    }
}
