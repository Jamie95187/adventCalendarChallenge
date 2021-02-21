package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubes {

    Cube[][][] grid;
    int xMax = 4;
    int yMax = 4;
    int zMax = 2;
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
            grid = new Cube[5][5][3];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++){
                    grid[i][j][0] = new Cube(false);
                    grid[i][j][2] = new Cube(false);
                }
            }
            for (int l = 0; l < 5; l++) {
                for (int k = 0; k < 3; k++) {
                    grid[0][l][k] = new Cube(false);
                    grid[4][l][k] = new Cube(false);
                    grid[l][0][k] = new Cube(false);
                    grid[l][4][k] = new Cube(false);
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
                    if (grid[x+1][y+1][z+1].getState()) {
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
                    if (grid[x+1][y-1][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z-1].getState()) {
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
                    if (grid[x][y][z].getState()) {
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
                    if (grid[x][y][z].getState()) {
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
                    if (grid[x-1][y][z+1].getState()) {
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
//
//        System.out.println("Initial grid data ");
//
//        for(int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                for (int k = 0; k < grid[i][j].length; k++) {
//                    System.out.println("i = " + i + " j = " + j + " k = " + k + " state = " + grid[i][j][k].getState());
//                }
//            }
//        }
//
//        System.out.println("-----------------------------------------------------------");

        Cube[][][] copyOfGrid = new Cube[xMax + 1][yMax + 1][zMax + 1];

//        System.out.println("Gid After One Generation");

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
                            incrX = true;
                        }
                        if (countYZeroPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3) {
                            incrY = true;
                        }
                        if (countZMaxPlane(x, y, z) == 3 || countZZeroPlane(x, y, z) == 3) {
                            incrZ = true;
                        }
                    } else {
                        if (countCorners(x, y, z) == 3 || countXZeroPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3 ||
                                countYZeroPlane(x, y, z) == 3 || checkNeighboursForInnerCube(x, y, z) == 3 || countCorners(x, y, z) == 2 || countXZeroPlane(x, y, z) == 2
                                || countXMaxPlane(x, y, z) == 2 || countYMaxPlane(x, y, z) == 2 || countYZeroPlane(x, y, z) == 2 || checkNeighboursForInnerCube(x, y, z) ==  2
                                || countZZeroPlane(x, y, z) == 3 || countZMaxPlane(x, y, z) == 2) {
                            copyOfGrid[x][y][z] = new Cube(true);
                        } else {
                            copyOfGrid[x][y][z] = new Cube(false);
                        }
                        if (countXZeroPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 3 || countXMaxPlane(x, y, z) == 2 || countXZeroPlane(x, y, z) == 2) {
                            incrX = true;
                        }
                        if (countYZeroPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 3 || countYMaxPlane(x, y, z) == 2 || countYZeroPlane(x, y, z) == 2) {
                            incrY = true;
                        }
                        if (countZZeroPlane(x, y, z) == 3 || countZMaxPlane(x, y, z) == 3 || countZMaxPlane(x, y, z) == 2 || countZZeroPlane(x, y, z) == 2) {
                            incrZ = true;
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

        if (incrX) {
            xMax = xMax + 2;
        }
        if (incrY) {
            yMax = yMax + 2;
        }
        if (incrZ) {
            zMax = zMax + 2;
        }

    }

    private void renderNewGrid(Cube[][][] copyOfGrid) {
        
    }

    public void test() {
        readInitialGrid();
//        for(int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                for (int k = 0; k < grid[i][j].length; k++) {
//                    System.out.println("i = " + i + " j = " + j + " k = " + k + " state = " + grid[i][j][k].getState());
//                }
//            }
//        }
        oneGeneration();
    }

}
