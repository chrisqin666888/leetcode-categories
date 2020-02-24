package Dynamic_Programming.P5_Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            int cur = Math.max(genLen(s, i, i), genLen(s, i, i+ 1));
            if (cur > len) {
                len = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    private int genLen(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
