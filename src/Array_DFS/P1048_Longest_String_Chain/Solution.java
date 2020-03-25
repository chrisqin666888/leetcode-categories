package Array_DFS.P1048_Longest_String_Chain;

import java.util.*;

public class Solution {
    public int longestStrChain(String[] words) {
        int res = 0;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Collections.addAll(set, words);
        for(String word : words) res = Math.max(res, dfs(map, set, word));
        return res;
    }

    private int dfs(Map<String, Integer> map, Set<String> set, String word) {
        if (map.containsKey(word)) return map.get(word);
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            String nextWord = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(nextWord)) {
                count = Math.max(count, dfs(map, set, nextWord));
            }
        }
        map.put(word, count + 1);
        return count + 1;
    }
}
