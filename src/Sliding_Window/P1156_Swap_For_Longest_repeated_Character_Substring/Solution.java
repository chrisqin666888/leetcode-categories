package Sliding_Window.P1156_Swap_For_Longest_repeated_Character_Substring;

public class Solution {
    public int maxrepOpt1(String text) {
        if (text == null || text.length() <= 0) return 0;
        int len = text.length();

        int[] count = new int[256];
        int unique_char = 0;
        for(char c : text.toCharArray()) {
            if (count[c - 'a'] == 0) unique_char++;
            count[c - 'a']++;
        }
        // there is no repeated character
        if (unique_char == len) return 1;
        // if there is only on repeated character
        if (unique_char == 1) return len;

        int maxLength = 0;
        for(int i = 0; i < len;) {
            char left_bound = text.charAt(i);
            int cur_window = 0;
            int swap_time = 1;
            int next_start_bound = i + 1;

            for(int j = i; j < len; j++) {
                if (text.charAt(j) == left_bound) cur_window++;
                else if (swap_time-- > 0 && (count[left_bound - 'a'] - cur_window) >= 1) {
                    cur_window++;
                    next_start_bound = j;
                } else {
                    break;
                }
            }

            cur_window = Math.min(cur_window, count[left_bound - 'a']);
            maxLength = Math.max(maxLength, cur_window);
            i = next_start_bound;
        }

        return maxLength;
    }
}
