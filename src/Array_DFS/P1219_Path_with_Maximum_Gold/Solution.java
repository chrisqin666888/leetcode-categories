package Array_DFS.P1219_Path_with_Maximum_Gold;

public class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, findMaxGold(grid, i, j));
            }
        }

        return maxGold;
    }

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int findMaxGold(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;

        int origin = grid[r][c];
        grid[r][c] = 0;
        int maxGold = 0;

        for(int[] dir : directions) {
            int x = r + dir[0];
            int y = c + dir[1];
            maxGold = Math.max(maxGold, findMaxGold(grid, x, y));
        }

        grid[r][c] = origin;

        return maxGold + origin;
    }
}
