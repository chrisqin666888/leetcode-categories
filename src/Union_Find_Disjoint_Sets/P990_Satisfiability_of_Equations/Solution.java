package Union_Find_Disjoint_Sets.P990_Satisfiability_of_Equations;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++) parent[i] = i;

        for(String s : equations) {
            if (s.charAt(1) == '=') {
                union(parent, s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        for(String s : equations) {
            if (s.charAt(1) == '!') {
                if (find(parent, s.charAt(0) - 'a') == find(parent, s.charAt(3) - 'a')) return false;
            }
        }

        return true;
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union (int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}
