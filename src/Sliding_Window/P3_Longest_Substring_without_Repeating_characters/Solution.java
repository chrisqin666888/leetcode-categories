package Sliding_Window.P3_Longest_Substring_without_Repeating_characters;
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(j)) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
