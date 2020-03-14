package Union_Find_Disjoint_Sets.P839_Similar_String_Groups;

public class Solution {
    public int numSimilarGroups(String[] A) {
        UnionFind uf = new UnionFind(A.length);
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; i++) {
                if (isSimilar(A[i], A[j])) {
                    uf.union(i, j);
                    if (uf.getGroups() == 1) {
                        return 1;
                    }
                }
            }
        }

        return uf.getGroups();
    }

    private boolean isSimilar(String a, String b) {
        int n = 0;
        if (a.length() != b.length()) return false;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++n == 3) {
                return false;
            }
        }

        return true;
    }

    public class UnionFind {
        int[] parent;
        int[] rank;
        int groups;

        public int getGroups() {
            return groups;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
            this.groups = n;
        }

        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (rank[px] > rank[py]) {
                parent[py] = px;
                rank[px]++;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            groups--;
        }
    }
}
