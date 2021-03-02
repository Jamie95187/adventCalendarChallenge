package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubes {

    Cube[][][] grid;

    // For tests
    int xMax = 2;
    int yMax = 2;
    int zMax = 2;

//    int xMax = 4;
//    int yMax = 4;
//    int zMax = 2;
    boolean incrX = false;
    boolean incrY = false;
    boolean incrZ = false;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/exampleGrid.txt"
            ));
            grid = new Cube[xMax+1][yMax+1][zMax+1];
            for (int i = 0; i <= xMax; i++) {
                for (int j = 0; j <= yMax; j++){
                    grid[i][j][0] = new Cube(false);
                    grid[i][j][zMax] = new Cube(false);
                }
            }
            for (int l = 0; l <= xMax; l++) {
                for (int k = 0; k <= zMax; k++) {
                    grid[0][l][k] = new Cube(false);
                    grid[xMax][l][k] = new Cube(false);
                    grid[l][0][k] = new Cube(false);
                    grid[l][yMax][k] = new Cube(false);
                }
            }
            String line = reader.readLine();
            int yCounter = 1;
            while(line != null) {
                char[] charArray = line.toCharArray();
                int xCounter = 1;
                for (char c : charArray) {
                    if (c == '.') {
                        grid[xCounter][yCounter][1] = new Cube(false);
                    } else {
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

    private int checkNeighboursForInnerCube(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (x != 0 && x != xMax && y != 0 && y != yMax && z != 0 && z != zMax) {
            // z = -1
            if (grid[x-1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }

            // z = 0
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }

            // z = +1
            if (grid[x-1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    private int testCheckNeighboursForInnerCube(int x, int y, int z, Cube[][][] grid) {
        int aliveNeighbours = 0;
        if (x != 0 && x != xMax && y != 0 && y != yMax && z != 0 && z != zMax) {
            // z = -1
            if (grid[x-1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }

            // z = 0
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }

            // z = +1
            if (grid[x-1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    private int countXZeroPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (x == 0) {
            if (y == 0) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else if (y == yMax) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else {
                if (z == 0) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                } else if (z == zMax) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                } else {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        return aliveNeighbours;
    }

    private int testCountXZeroPlane(int x, int y, int z, Cube[][][] grid) {
        int aliveNeighbours = 0;
        if (x == 0) {
            if (y == 0) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else if (y == yMax) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else {
                if (z == 0) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                } else if (z == zMax) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                } else {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        return aliveNeighbours;
    }

    private int countXMaxPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (x == xMax) {
            if (y == 0) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else if (y == yMax) {
                if (z != 0 && z != zMax) {
                    if (grid[x][y - 1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y - 1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z + 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y - 1][z + 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y][z + 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y - 1][z + 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z - 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y - 1][z - 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y][z - 1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x - 1][y - 1][z - 1].getState()) {
                        aliveNeighbours++;
                    }
                }
            } else {
                if (z == 0) {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                } else if ( z == zMax ) {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                } else {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x-1][y+1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        return aliveNeighbours;
    }

    private int countYZeroPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (y == 0) {
            if (z == 0 && x != 0 && x != xMax) {
                if (grid[x][y][z + 1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x + 1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x + 1][y][z + 1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x - 1][y][z + 1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x - 1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y + 1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y + 1][z + 1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x + 1][y + 1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x + 1][y + 1][z + 1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x - 1][y + 1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x - 1][y + 1][z + 1].getState()) {
                    aliveNeighbours++;
                }
            } else if (z == zMax && x != 0 && x != xMax) {
                if (grid[x][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
            } else if (x != 0 && x != xMax && z != 0 && z != zMax) {
                if (grid[x][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y+1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y+1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y+1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y+1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y+1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y][z+1].getState()) {
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

    private int countYMaxPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (y == yMax) {
            if (z == 0 && x != 0 && x != xMax) {
                if (grid[x][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
            } else if (z == zMax && x != 0 && x != xMax) {
                if (grid[x][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
            } else if (x != 0 && x != xMax && z != 0 && z != zMax) {
                if (grid[x][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z-1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x+1][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
                if (grid[x-1][y-1][z+1].getState()) {
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

    private int countZZeroPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (z == 0 && x != 0 && x != xMax && y != 0 && y != yMax) {
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    private int countZMaxPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (z == zMax && x != 0 && x != xMax && y != 0 && y != yMax) {
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    private int countCorners(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (x == 0 && y == 0 && z == 0) {
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == 0 && y == 0 && z == zMax) {
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == xMax && y == 0 && z == 0) {
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z+1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == 0 && y == yMax && z == 0) {
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == 0 && y == yMax && z == zMax) {
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x+1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == xMax && y == 0 && z == zMax) {
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y+1][z-1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == xMax && y == yMax && z == 0) {
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z+1].getState()) {
                aliveNeighbours++;
            }
        } else if (x == xMax && y == yMax && z == zMax) {
            if (grid[x][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
            if (grid[x-1][y-1][z-1].getState()) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    public void oneGeneration() {

        Cube[][][] copyOfGrid = new Cube[xMax + 1][yMax + 1][zMax + 1];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                for (int z = 0; z < grid[0][0].length; z++) {
                    if (!grid[x][y][z].getState()) {
                        if (countCorners(x, y, z) == 3 || countXZeroPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3 ||
                                countYZeroPlane(x, y, z) == 3 || checkNeighboursForInnerCube(x, y, z) == 3 || countZZeroPlane(x, y, z) == 3 || countZMaxPlane(x, y, z) == 3) {
                            copyOfGrid[x][y][z] = new Cube(true);
                        } else {
                            copyOfGrid[x][y][z] = new Cube(false);
                        }
                        if (countXZeroPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 3) {
                            this.incrX = true;
                        }
                        if (countYZeroPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3) {
                            this.incrY = true;
                        }
                        if (countZMaxPlane(x, y, z) == 3 || countZZeroPlane(x, y, z) == 3) {
                            this.incrZ = true;
                        }
                    } else {
                        if (countCorners(x, y, z) == 3 || countXZeroPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3 ||
                                countYZeroPlane(x, y, z) == 3 || countZZeroPlane(x, y, z) == 3 || countZMaxPlane(x, y, z) == 3 || checkNeighboursForInnerCube(x, y, z) == 3 ||
                                countCorners(x, y, z) == 2 || countXZeroPlane(x, y, z) == 2 || countXMaxPlane(x, y, z) == 2 || countYZeroPlane(x, y, z) == 2 ||
                                countYMaxPlane(x, y, z) == 2 || countZZeroPlane(x, y, z) == 2 || countZMaxPlane(x, y, z) == 2 || checkNeighboursForInnerCube(x, y, z) == 2) {
                            copyOfGrid[x][y][z] = new Cube(true);
                        } else {
                            copyOfGrid[x][y][z] = new Cube(false);
                        }
                    }
                }
            }
        }

//        for(int x = 0; x < copyOfGrid.length; x++) {
//            for (int y = 0; y < copyOfGrid[x].length; y++) {
//                for (int z = 0; z < copyOfGrid[x][y].length; z++) {
//                    System.out.println("x = " + x + " y = " + y + " z = " + z + " state = " + copyOfGrid[x][y][z].getState());
//                }
//            }
//        }

        if (this.incrX) {
            this.xMax = this.xMax + 2;
        }
        if (this.incrY) {
            this.yMax = this.yMax + 2;
        }
        if (this.incrZ) {
            this.zMax = zMax + 2;
        }
        renderNewGrid(copyOfGrid);
        this.incrX = false;
        this.incrY = false;
        this.incrZ = false;
    }

    private void renderNewGrid(Cube[][][] copyOfGrid) {
        Cube[][][] newGrid = new Cube[xMax + 1][yMax + 1][zMax + 1];

        for (int i = 0; i < xMax + 1; i++) {
            for (int j = 0; j < yMax + 1; j++){
                newGrid[i][j][0] = new Cube(false);
                newGrid[i][j][zMax] = new Cube(false);
            }
        }
        for (int y = 0; y < yMax + 1; y++) {
            for (int k = 0; k < zMax + 1; k++) {
                newGrid[0][y][k] = new Cube(false);
                newGrid[xMax][y][k] = new Cube(false);
            }
        }
        for (int x = 0; x < xMax + 1; x++) {
            for (int z = 0; z < zMax + 1; z++) {
                newGrid[x][0][z] = new Cube(false);
                newGrid[x][yMax][z] = new Cube(false);
            }
        }

        if (!this.incrX && !this.incrY && !this.incrZ) {
            for (int x = 0; x <= xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x][y][z];
                    }
                }
            }
        } else if (this.incrX && this.incrY && !this.incrZ) {
            for (int x = 1; x < xMax; x++) {
                for (int y = 1; y < yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x-1][y-1][z];
                    }
                }
            }
        } else if (this.incrX && !this.incrY && !this.incrZ) {
            for (int x = 1; x < xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x-1][y][z];
                    }
                }
            }
        } else if (this.incrX && !this.incrY && this.incrZ) {
            for (int x = 1; x < xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    for (int z = 1; z < zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x-1][y][z-1];
                    }
                }
            }
        } else if (!this.incrX && this.incrY && !this.incrZ) {
            for (int x = 0; x <= xMax; x++) {
                for (int y = 1; y < yMax; y++) {
                    for (int z = 0; z <= zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x][y-1][z];
                    }
                }
            }
        } else if (!this.incrX && this.incrY && this.incrZ) {
            for (int x = 0; x <= xMax; x++) {
                for (int y = 1; y < yMax; y++) {
                    for (int z = 1; z < zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x][y-1][z-1];
                    }
                }
            }
        } else if (!this.incrX && !this.incrY && this.incrZ) {
            for (int x = 0; x <= xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    for (int z = 1; z < zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x][y][z-1];
                    }
                }
            }
        } else if (this.incrX && this.incrY && this.incrZ) {
            for (int x = 1; x < xMax; x++) {
                for (int y = 1; y < yMax; y++) {
                    for (int z = 1; z < zMax; z++) {
                        newGrid[x][y][z] = copyOfGrid[x-1][y-1][z-1];
                    }
                }
            }
        }
        grid = newGrid;
    }

    private void printGrid() {
        for (int z = 0; z <= zMax; z++) {
            System.out.println("------------------ " + z + " Z Plane --------------------");
            for (int x = 0; x <= xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    System.out.println("x = " + x + " y = " + y + " state = " + grid[x][y][z].getState());
                }
            }
            System.out.println(" ");
        }
    }

    private int countActiveCubes() {
        int activeCubes = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                for (int z = 0; z <= zMax; z++) {
                    if (grid[x][y][z].getState()) {
                        activeCubes++;
                    }
                }
            }
        }
        return activeCubes;
    }

    public void test() {
        readInitialGrid();
        System.out.println("Number of active cubes = " + countActiveCubes());
        oneGeneration();
        oneGeneration();
        oneGeneration();
        oneGeneration();
        oneGeneration();
        oneGeneration();
        System.out.println("Number of active cubes = " + countActiveCubes());
    }

    public void testInnerGrid() {
        Cube[][][] gridOne = new Cube[3][3][3];
//        for(int x = 0; x < 3; x++) {
//            for (int y = 0; y < 3; y++) {
//                for (int z = 0; z < 3; z++) {
//                    gridOne[x][y][z] = new Cube(false);
//                }
//            }
//        }
//        gridOne[0][0][0] = new Cube(true);
//        gridOne[2][2][2] = new Cube(true);
//        gridOne[2][2][0] = new Cube(true);
//        gridOne[0][0][2] = new Cube(true);

        /* Test for grid such that
           z = 0
           #..
           ...
           ..#

           z = 1
           ...
           ...
           ...

           z = 2
           #..
           ...
           ..#

           We expect the method to return 4 when we call on coordinate (1,1,1)
        */

//        gridOne[0][0][0] = new Cube(true);
//        gridOne[0][0][2] = new Cube(true);

        /* Test for grid such that
           z = 0
           #..
           ...
           ...

           z = 1
           ...
           ...
           ...

           z = 2
           #..
           ...
           ...

           We expect the method to return 2 when we call on coordinate (1,1,1)
        */

//        gridOne[2][1][0] = new Cube(true);
//        gridOne[0][1][1] = new Cube(true);
//        gridOne[2][1][2] = new Cube(true);

        /* Test for grid such that
           z = 0
           ...
           ..#
           ...

           z = 1
           ...
           #..
           ...

           z = 2
           ...
           ..#
           ...

           We expect the method to return 3 when we call on coordinate (1,1,1)
        */

        /* Test for grid such that
           z = 0
           ###
           ###
           ###

           z = 1
           ###
           #.#
           ###

           z = 2
           ###
           ###
           ###

           We expect the method to return 26 when we call on coordinate (1,1,1)
        */

        for(int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    gridOne[x][y][z] = new Cube(true);
                }
            }
        }

        gridOne[1][1][1] = new Cube(false);

        System.out.println(testCheckNeighboursForInnerCube(1,1,1, gridOne));
    }

    public void testXZeroPlane() {
        Cube[][][] gridOne = new Cube[3][3][3];
        for(int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    gridOne[x][y][z] = new Cube(false);
                }
            }
        }

        /* Test for grid such that
           z = 0
           ##.
           ##.
           ...

           z = 1
           x#.
           ##.
           ...

           z = 2
           ##.
           ##.
           ...

           We expect the method to return 11 when we call on coordinate (0,0,1)

           gridOne[0][0][0] = new Cube(true);
           gridOne[1][0][0] = new Cube(true);
           gridOne[1][1][0] = new Cube(true);
           gridOne[0][1][0] = new Cube(true);
           gridOne[0][1][1] = new Cube(true);
           gridOne[1][0][1] = new Cube(true);
           gridOne[1][1][1] = new Cube(true);
           gridOne[0][0][2] = new Cube(true);
           gridOne[0][1][2] = new Cube(true);
           gridOne[1][0][2] = new Cube(true);
           gridOne[1][1][2] = new Cube(true);


           System.out.println(testCountXZeroPlane(0,0,1, gridOne));
        */

        /* Test for grid such that
           z = 0
           ...
           ##.
           ##.

           z = 1
           ...
           ##.
           x#.

           z = 2
           ...
           ##.
           ##.

           We expect the method to return 11 when we call on coordinate (0,2,1)

           gridOne[0][1][0] = new Cube(true);
           gridOne[0][2][0] = new Cube(true);
           gridOne[1][1][0] = new Cube(true);
           gridOne[1][2][0] = new Cube(true);
           gridOne[0][1][1] = new Cube(true);
           gridOne[1][1][1] = new Cube(true);
           gridOne[1][2][1] = new Cube(true);
           gridOne[0][1][2] = new Cube(true);
           gridOne[0][2][2] = new Cube(true);
           gridOne[1][1][2] = new Cube(true);
           gridOne[1][2][2] = new Cube(true);


           System.out.println(testCountXZeroPlane(0,2,1, gridOne));
        */

        /* Test for grid such that
           z = 0
           ##.
           x#.
           ##.

           z = 1
           ##.
           ##.
           ##.

           z = 2
           ...
           ...
           ...

           We expect the method to return 11 when we call on coordinate (0,1,0)

           gridOne[0][0][0] = new Cube(true);
           gridOne[0][2][0] = new Cube(true);
           gridOne[1][0][0] = new Cube(true);
           gridOne[1][1][0] = new Cube(true);
           gridOne[1][2][0] = new Cube(true);
           gridOne[0][0][1] = new Cube(true);
           gridOne[0][1][1] = new Cube(true);
           gridOne[0][2][1] = new Cube(true);
           gridOne[1][0][1] = new Cube(true);
           gridOne[1][1][1] = new Cube(true);
           gridOne[1][2][1] = new Cube(true);

           System.out.println(testCountXZeroPlane(0,1,0, gridOne));
        */

        /* Test for grid such that
           z = 0
           ...
           ...
           ...

           z = 1
           ##.
           ##.
           ##.

           z = 2
           ##.
           x#.
           ##.

           We expect the method to return 11

            gridOne[0][0][2] = new Cube(true);
            gridOne[0][2][2] = new Cube(true);
            gridOne[1][0][2] = new Cube(true);
            gridOne[1][1][2] = new Cube(true);
            gridOne[1][2][2] = new Cube(true);
            gridOne[0][0][1] = new Cube(true);
            gridOne[0][1][1] = new Cube(true);
            gridOne[0][2][1] = new Cube(true);
            gridOne[1][0][1] = new Cube(true);
            gridOne[1][1][1] = new Cube(true);
            gridOne[1][2][1] = new Cube(true);

            System.out.println(testCountXZeroPlane(0,1,2, gridOne));
        */

        /* Test for grid such that
           z = 0
           ##.
           ##.
           ##.

           z = 1
           ##.
           x#.
           ##.

           z = 2
           ##.
           ##.
           ##.

           We expect the method to return 17
         */

        gridOne[0][0][0] = new Cube(true);
        gridOne[0][1][0] = new Cube(true);
        gridOne[0][2][0] = new Cube(true);
        gridOne[1][0][0] = new Cube(true);
        gridOne[1][1][0] = new Cube(true);
        gridOne[1][2][0] = new Cube(true);
        gridOne[0][0][1] = new Cube(true);
        gridOne[0][2][1] = new Cube(true);
        gridOne[1][0][1] = new Cube(true);
        gridOne[1][1][1] = new Cube(true);
        gridOne[1][2][1] = new Cube(true);
        gridOne[0][0][2] = new Cube(true);
        gridOne[0][1][2] = new Cube(true);
        gridOne[0][2][2] = new Cube(true);
        gridOne[1][0][2] = new Cube(true);
        gridOne[1][1][2] = new Cube(true);
        gridOne[1][2][2] = new Cube(true);

        System.out.println(testCountXZeroPlane(0,1,1, gridOne));
    }

}
