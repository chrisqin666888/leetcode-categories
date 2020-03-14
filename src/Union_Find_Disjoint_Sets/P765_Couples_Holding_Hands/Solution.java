package Union_Find_Disjoint_Sets.P765_Couples_Holding_Hands;

public class Solution {

    public static class UnionFind {
        int[] parents;
        int count;

        public UnionFind(int n) {
            this.parents = new int[n];
            for(int i = 0; i < n; i++) parents[i] = i;
            count = n;
        }

        private int find(int x) {
            if (x != parents[x]) parents[x] = find(parents[x]);
            return parents[x];
        }

        private void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a != b) {
                parents[a] = b;
                count--;
            }
        }
    }

    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UnionFind uf = new UnionFind(N);
        for(int i = 0; i < N; i++) {
            int a = row[2 * i];
            int b = row[2 * i + 1];
            uf.union(a / 2, b/  2);
        }
        return uf.count;
    }
}
