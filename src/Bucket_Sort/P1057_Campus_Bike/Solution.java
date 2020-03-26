package Bucket_Sort.P1057_Campus_Bike;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;
        int n = bikes.length;
        boolean[] assigned = new boolean[m];
        boolean[] occupied = new boolean[n];
        int[] res = new int[m];
        List<int[]>[] bucket = new List[2001];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int dist = dist(workers[i], bikes[j]);

                if (bucket[dist] == null)
                    bucket[dist] = new ArrayList<>();

                bucket[dist].add(new int[]{i, j});
            }
        }

        for(int i = 0; i < 2001; i++) {
            if (bucket[i] == null) continue;
            int size = bucket[i].size();
            for(int j = 0; j < size; j++) {
                int worker = bucket[i].get(j)[0];
                int bike = bucket[i].get(j)[1];

                if (!assigned[worker] && !occupied[bike]) {
                    res[worker] = bike;
                    assigned[worker] = true;
                    occupied[bike] = true;
                }
            }
        }

        return res;
    }

    private int dist(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
}
