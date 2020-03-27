package Array_General.P939_Maximum_Area_Rectangle;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points)
            set.add(p[0] + "#" + p[1]);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                String p1 = points[i][0] + "#" + points[j][1];
                String p2 = points[j][0] + "#" + points[i][1];
                if (set.contains(p1) && set.contains(p2)) {
                    int area = Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1]));
                    min = Math.min(min, area);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
