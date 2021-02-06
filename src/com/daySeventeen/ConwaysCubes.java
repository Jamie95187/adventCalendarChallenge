package com.daySeventeen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConwaysCubes {

    Cube[][][] grid;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeventeen/initialGrid.txt"
            ));
            grid = new Cube[8][8][1];
            String line = reader.readLine();
            int yCounter = 0;
            while(line != null) {
                char[] charArray = line.toCharArray();
                int xCounter = 0;
                for (char c : charArray) {
                    if (c == '.') {
                        grid[xCounter][yCounter][0] = new Cube(false);
                    } else {
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

    public int countAliveNeighbours(int x, int y, int z) {
        int aliveNeighbours = 0;
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
