package Union_Find_Disjoint_Sets.P1061_Lexicographically_Smallest_Equavalent_String;

public class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++) parent[i] = i;

        for(int i = 0; i < A.length(); i++) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';

            int pa = find(parent ,a);
            int pb = find(parent, b);

            if (pa < pb ) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            sb.append((char)('a' + find(parent, c - 'a')));
        }

        return sb.toString();
    }

    private int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }
}
