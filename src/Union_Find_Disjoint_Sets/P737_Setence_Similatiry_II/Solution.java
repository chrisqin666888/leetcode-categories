package Union_Find_Disjoint_Sets.P737_Setence_Similatiry_II;
import java.util.*;

public class Solution {

    public class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int Find(int x) {
            if (x != parent[x]) {
                parent[x] = Find(parent[x]);
            }
            return parent[x];
        }

        public boolean Union(int x, int y) {
            int px = Find(x);
            int py = Find(y);

            if (px == py) return false;
            if (rank[px] > rank[py]) rank[py] = px;
            if (rank[py] > rank[px]) rank[px] = py;
            if (rank[py] == rank[px]) {
                parent[px] = py;
                rank[py]++;
            }
            return false;
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        UnionFind unionFind = new UnionFind(2 * pairs.size());
        for(List<String> pair : pairs) {
            for(String word : pair) {
                if (!map.containsKey(word)) {
                    map.put(word, count++);
                }
            }
            unionFind.Union(map.get(pair.get(0)), map.get(pair.get(1)));
        }

        for(int i = 0; i < words1.length; i++) {
            String word1 = words1[i], word2 = words2[i];
            if (word1.equals(word2)) continue;
            if (!map.containsKey(word1) || !map.containsKey(word2) ||
                    unionFind.Find(map.get(word1)) != unionFind.Find(map.get(word2))) {
                return false;
            }
        }

        return true;
    }
}
















