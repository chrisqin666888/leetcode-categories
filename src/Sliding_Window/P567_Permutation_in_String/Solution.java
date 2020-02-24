package Sliding_Window.P567_Permutation_in_String;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] freq = new int[26];
        for(int i = 0; i < len1; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < len2; i++) {
            freq[s2.charAt(i) - 'a']--;
            if (i - len1 >= 0) {
                freq[s2.charAt(i - len1) - 'a']++;
            }
            if (allZero(freq)) return true;
        }

        return false;
    }

    private boolean allZero(int[] freq) {
        for(int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
    }
}
