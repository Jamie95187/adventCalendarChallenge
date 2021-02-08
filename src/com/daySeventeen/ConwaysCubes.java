package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubes {

    Cube[][][] grid;
    int xMax = 10;
    int yMax = 10;
    int zMax = 10;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
            ));
            grid = new Cube[10][10][3];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++){
                    grid[i][j][0] = new Cube(false);
                    grid[i][j][2] = new Cube(false);
                }
            }
            for (int l = 0; l < 10; l++) {
                for (int k = 0; k < 3; k++) {
                    grid[0][l][k] = new Cube(false);
                    grid[9][l][k] = new Cube(false);
                    grid[l][0][k] = new Cube(false);
                    grid[l][9][k] = new Cube(false);
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

    public int countAliveNeighbours(int x, int y, int z) {
        int aliveNeighbours = 0;
        aliveNeighbours = aliveNeighbours + checkXZeroPlane(x, y, z);
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
        return aliveNeighbours;
    }

    private int checkXZeroPlane(int x, int y, int z) {
        int aliveNeighbours = 0;
        if (x == 0) {
            if (y == 0) {
                if (z == 0) {
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
                } else if (z == zMax) {
                    if (grid[x][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y+1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
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
                    if (grid[x][y][z-1].getState()) {
                        aliveNeighbours++;
                    }
                } else {
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
                if (z == 0) {
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
                } else if (z == zMax) {
                    if (grid[x][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y][z].getState()) {
                        aliveNeighbours++;
                    }
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
                } else {
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
                    if (grid[x+1][y-1][z].getState()) {
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
                    if (grid[x+1][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x+1][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y-1][z+1].getState()) {
                        aliveNeighbours++;
                    }
                    if (grid[x][y][z+1].getState()) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        return aliveNeighbours;
    }

    public void test() {
        readInitialGrid();
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                for (int k = 0; k < grid[i][j].length; k++) {
                    System.out.println("i = " + i + " j = " + j + " k = " + k + " state = " + grid[i][j][k].getState());
                }
            }
        }
    }

}
