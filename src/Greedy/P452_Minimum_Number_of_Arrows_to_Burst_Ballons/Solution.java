package Greedy.P452_Minimum_Number_of_Arrows_to_Burst_Ballons;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCount = 1;
        for(int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) continue;

            arrowCount++;
            arrowPos = points[i][1];

        }
        return arrowCount;
    }
}
