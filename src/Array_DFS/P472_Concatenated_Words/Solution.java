package Array_DFS.P472_Concatenated_Words;
import java.util.*;

// problem link
// https://leetcode.com/problems/concatenated-words/

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < words.length; i++) {
            if (words[i].length() != 0
                    && dfs(seen, words[i])) {
                res.add(words[i]);
            }
            seen.add(words[i]);
        }
        return res;
    }

    private boolean dfs(Set<String> seen, String word) {
        if (word == null || word.length() == 0) return true;

        if (seen.contains(word)) return true;
        int len = word.length();
        for(int i = 1; i <= len; i++) {
            String temp = word.substring(0, i);
            if (seen.contains(temp)) {
                if (dfs(seen, word.substring(i))) {
                    seen.add(word);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(solution.findAllConcatenatedWordsInADict(input));
    }
}
