package Sliding_Window.P395_Longest_SubString_With_At_Least_K_Repeating_Characters;

public class Solution {
    public int longestSubstring(String s, int k) {
        return helper(0, s.length(), s, k);
    }

    public int helper(int start, int end, String s, int k) {
        int [] char_freq = new int[26];
        for (int index = start; index < end; index++) {
            char_freq[s.charAt(index) - 'a']++;
        }

        for(int i = start; i < end; i++) {
            int freq = char_freq[s.charAt(i) - 'a'];

            if (freq > 0 && freq < k) {
                int left = helper(start, i, s, k);
                int right = helper(i + 1, end, s, k);
                return Math.max(left, right);
            }
        }
        return end - start;
    }
}
