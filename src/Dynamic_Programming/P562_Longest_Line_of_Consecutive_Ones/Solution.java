package Dynamic_Programming.P562_Longest_Line_of_Consecutive_Ones;

public class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int m = M.length, n = M[0].length;
        int[][][] dp = new int[m+1][n+2][4];
        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (M[i-1][j-1] == 1) {
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j-1][1] + 1;
                    dp[i][j][2] = dp[i-1][j][2] + 1;
                    dp[i][j][3] = dp[i-1][j+1][3] + 1;
                    for (int k = 0; k < 4; k++) {
                        max = Math.max(max, dp[i][j][k]);
                    }
                }
            }
        }

        return max;
    }
}
