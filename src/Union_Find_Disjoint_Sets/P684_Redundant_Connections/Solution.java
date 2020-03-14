package Union_Find_Disjoint_Sets.P684_Redundant_Connections;

public class Solution {
    class UnionFindSet {
        int[] parents;
        int[] ranks;

        public UnionFindSet(int size) {
            this.parents = new int[size + 1];
            this.ranks = new int[size + 1];
            for(int i = 0; i < parents.length; i++) parents[i] = i;

        }

        public int Find(int x) {
            if (x != parents[x]) parents[x] = Find(parents[x]);
            return parents[x];
        }

        public boolean Union(int x, int y) {
            int px = Find(x);
            int py = Find(y);
            if(px == py) return false;
            if (ranks[px] > ranks[py]) ranks[py] = px;
            if (ranks[py] > ranks[px]) ranks[px] = py;
            if (ranks[py] == ranks[px]) {
                parents[py] = px;
                ranks[px]++;
            }
            return false;
        }

        public int[] findRedundantConnection(int[][] edges) {
            UnionFindSet cluster = new UnionFindSet(edges.length);

            for(int[] edge : edges) {
                if (!cluster.Union(edge[0], edge[1])) return edge;
            }
            return new int[]{};
        }
    }
}
