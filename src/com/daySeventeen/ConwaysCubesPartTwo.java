package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubesPartTwo {
    Cube[][][][] grid;

//     For example grid
//    int xMax = 4;
//    int yMax = 4;
//    int zMax = 2;
//    int wMax = 2;

    int xMax = 10;
    int yMax = 10;
    int zMax = 2;
    int wMax = 2;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/exampleGrid.txt"
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
                        grid[xCounter][yCounter][0][0] = new Cube(true);
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

    public int countZPlaneNotInWPlane(int x, int y, int z, int w) {
        int activeCubes = 0;
        if (grid[x][y][z][w].getState()) {
            activeCubes++;
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

    public int countZPlane(int x, int y, int z, int w) {
        int activeCubes = 0;
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
                for (int z = 0; z < zMax; z++) {
                    int activeNeighbours = countZPlane(x,y,z,0) + countZPlusOnePlane(x,y,z,0) + (2 * countZPlaneNotInWPlane(x,y,z,1) ) + (2 * countZPlusOnePlane(x,y,z,1) );
                    if (z == 0) {
                        if (!grid[x][y][z][0].getState()) {
                            if (activeNeighbours + countZPlusOnePlane(x,y,z,0) + (2 * countZPlusOnePlane(x,y,z,1) ) == 3) {
                                newGrid[x+1][y+1][z][0] = new Cube(true);
                            }
                        } else if (grid[x][y][z][0].getState()) {
                            if (activeNeighbours + countZPlusOnePlane(x,y,z,0) + (2 *countZPlusOnePlane(x,y,z,1) ) == 3 ||
                                    activeNeighbours + countZPlusOnePlane(x,y,z,0) + (2 * countZPlusOnePlane(x,y,z,1) )== 2) {
                                newGrid[x+1][y+1][z][0] = new Cube(true);
                            }
                        }
                    } else {
                        if (!grid[x][y][z][0].getState()) {
                            if (activeNeighbours + countZMinusOnePlane(x,y,z,0) + (2 * countZMinusOnePlane(x,y,z,1) ) == 3) {
                                newGrid[x+1][y+1][z][0] = new Cube(true);
                            }
                        } else if (grid[x][y][z][0].getState()) {
                            if (activeNeighbours + countZMinusOnePlane(x,y,z,0) + (2 * countZMinusOnePlane(x,y,z,1) ) == 3 ||
                                    activeNeighbours + countZMinusOnePlane(x,y,z,0) + (2 * countZMinusOnePlane(x,y,z,1) ) == 2) {
                                newGrid[x+1][y+1][z][0] = new Cube(true);
                            }
                        }
                    }
                }
            }
        }

        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z < zMax; z++) {
                    for (int w = 1; w < wMax; w++) {
                        int activeNeighbours = countZPlane(x,y,z,w) + countZPlusOnePlane(x,y,z,w) + countZPlaneNotInWPlane(x,y,z,w-1) + countZPlusOnePlane(x,y,z,w-1) + countZPlaneNotInWPlane(x,y,z,w+1) + countZPlusOnePlane(x,y,z,w+1);
                        if (z == 0) {
                            if (!grid[x][y][z][w].getState()) {
                                if (activeNeighbours + countZPlusOnePlane(x,y,z,w) + countZPlusOnePlane(x,y,z,w-1) + countZPlusOnePlane(x,y,z,w+1) == 3) {
                                    newGrid[x+1][y+1][z][w] = new Cube(true);
                                }
                            } else if (grid[x][y][z][w].getState()) {
                                if (activeNeighbours + countZPlusOnePlane(x,y,z,w) + countZPlusOnePlane(x,y,z,w-1) + countZPlusOnePlane(x,y,z,w+1) == 3 ||
                                        activeNeighbours + countZPlusOnePlane(x,y,z,w) + countZPlusOnePlane(x,y,z,w-1) + countZPlusOnePlane(x,y,z,w+1) == 2) {
                                    newGrid[x+1][y+1][z][w] = new Cube(true);
                                }
                            }
                        } else if (z != 0) {
                            if (!grid[x][y][z][w].getState()) {
                                if (activeNeighbours + countZMinusOnePlane(x,y,z,w) + countZMinusOnePlane(x,y,z,w-1) + countZMinusOnePlane(x,y,z,w+1) == 3) {
                                    newGrid[x+1][y+1][z][w] = new Cube(true);
                                }
                            } else if (grid[x][y][z][w].getState()) {
                                if (activeNeighbours + countZMinusOnePlane(x,y,z,w) + countZMinusOnePlane(x,y,z,w-1) + countZMinusOnePlane(x,y,z,w+1) == 3 ||
                                        activeNeighbours + countZMinusOnePlane(x,y,z,w) + countZMinusOnePlane(x,y,z,w-1) + countZMinusOnePlane(x,y,z,w+1) == 2) {
                                    newGrid[x+1][y+1][z][w] = new Cube(true);
                                }
                            }
                        }
                    }
                }
            }
        }

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
                for (int w = 0; w <= wMax; w++) {
                    for (int z = 0; z <= wMax; z++) {
                        int currentCountInWPlane = 0;
                        if (w == 0) {
                            if (z == 0) {
                                if (grid[x][y][z][w].getState()) {
                                    activeCubes++;
                                }
                            } else {
                                if (grid[x][y][z][w].getState()) {
                                    activeCubes++;
                                    activeCubes++;
                                }
                            }
                        } else if (w != 0) {
                            if (z == 0) {
                                if (grid[x][y][z][w].getState()) {
                                    activeCubes++;
                                    activeCubes++;
                                }
                            } else {
                                if (grid[x][y][z][w].getState()) {
                                    activeCubes++;
                                    activeCubes++;
                                    activeCubes++;
                                    activeCubes++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return activeCubes;
    }

    public void test() {
        readInitialGrid();
        System.out.println("BEFORE ANY GEN " + countActiveCubes());
//        System.out.println("Number of NEIGHBOURS AT 1,2,1,0 : ");
//        System.out.println(countZMinusOnePlane(1,2,1,0));
//        System.out.println(countZPlane(1,2,1,0) + countZPlusOnePlane(1,2,1,0) + (2 * countZPlaneNotInWPlane(1,2,1,1) ) + (2 * countZPlusOnePlane(1,2,1,1)  + countZMinusOnePlane(1,2,1,0) + (2 * countZMinusOnePlane(1,2,1,1) )));
//        countZPlane(x,y,z,0) + countZPlusOnePlane(x,y,z,0) + (2 * countZPlaneNotInWPlane(x,y,z,1) ) + (2 * countZPlusOnePlane(x,y,z,1)
//        printGrid();
//        System.out.println("Number of NEIGHBOURS AT 2,3,0,1 : ");
//        System.out.println(countZPlaneNotInWPlane(2,3,0,1));
//        System.out.println(countZPlusOnePlane(2,3,0,1));
        oneGeneration();
        System.out.println("AFTER ONE GEN " + countActiveCubes());
//        printGrid();
        oneGeneration();
        System.out.println("AFTER TWO GEN " + countActiveCubes());
        oneGeneration();
        oneGeneration();
        oneGeneration();
        oneGeneration();
        System.out.println("AFTER SIX GEN " + countActiveCubes());
//        printGrid();
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
