package Union_Find_Disjoint_Sets.P1101_The_Earliest_time_When_people_become_Friends;

import java.util.Arrays;

public class Solution {
    public int earliestAcq(int[][] logs, int N) {
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        for(int[] log: logs) {
            int person1 = log[1];
            int person2 = log[2];

            int parent1 = find(parent, person1);
            int parent2 = find(parent, person2);

            if (parent1 != parent2) {
                union(parent, parent1, parent2);
                N--;
                if (N == 1) return log[0];
            }
        }

        return -1;
    }

    public int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        if (find(parent, x) != find(parent, y)) {
            parent[x] = y;
        }
    }
}
