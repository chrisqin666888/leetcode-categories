package Dynamic_Programming.P576_Out_of_Boundary_Paths;

// problem link
// https://leetcode.com/problems/out-of-boundary-paths/

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int R = r + d[0];
                        int C = c + d[1];
                        if (R < 0 || R >= m || C < 0 || C >= n) {
                            result = (result + dp[r][c]) % MOD;
                        }
                        else {
                            temp[R][C] = (temp[R][C] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }

        return result;
    }
}
