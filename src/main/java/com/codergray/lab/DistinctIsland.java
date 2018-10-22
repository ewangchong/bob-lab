package com.codergray.lab;

import java.util.HashSet;
import java.util.Set;

public class DistinctIsland {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) {
        DistinctIsland di = new DistinctIsland();
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println("Number of distinct islands: " + di.numberofDistinctIslands(grid));
    }

    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        Set<String> set = new HashSet<>();

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String path = dfs(grid, i, j);
                    set.add(path);
                }
            }
        }

        for (String s : set) {
            System.out.println(s);
        }

        return set.size();
    }

    private String dfs(int[][] grid, int i, int j) {
        String path = "";

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (!isInbound(grid, x, y)) {
                continue;
            }

            if (grid[x][y] == 0) {
                continue;
            }

            grid[x][y] = 0;
            path += k + dfs(grid, x, y);
        }

        return path.length() != 0 ? path : ";";
    }

    private boolean isInbound(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        } else {
            return true;
        }
    }
}

