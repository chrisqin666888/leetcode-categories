package Dynamic_Programming.P576_Out_of_Boundary_Paths.Knight_Probability_in_Chessboard;
import java.util.*;

class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        int len = N;
        double dp[][] = new double[len][len];
        for(double[] row : dp) Arrays.fill(row, 1);
        for(int l = 0; l < K; l++) {
            double[][] temp = new double[len][len];
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    for(int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if(row >= 0 && row < len && col >= 0 && col < len)
                            temp[i][j] += dp[row][col];
                    }
                }
            }
            dp = temp;
        }
        return dp[r][c] / Math.pow(8, K);
    }
}
