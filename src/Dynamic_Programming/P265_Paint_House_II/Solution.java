package Dynamic_Programming.P265_Paint_House_II;

public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        int min1 = 0, min2 = 0, minIndex = -1;

        for (int i = 0; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE, curMinIndex = 0;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == minIndex ? min2 : min1);
                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curMinIndex = j;
                }
                else if (cost < curMin2) curMin2 = cost;
            }
            min1 = curMin1;
            min2 = curMin2;
            minIndex = curMinIndex;
        }
        return min1;
    }
}
