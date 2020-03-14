package Backtracking.P291_Word_Pattern_II;

import java.util.*;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        return wordPatternMatch(pattern, str,  map,  set,
                0, str.length() - 1, 0, pattern.length() - 1);
    }

    private boolean wordPatternMatch(String pattern, String str, String[] map, Set<String> set,
                                     int start, int end, int startP, int endP) {
        if (startP == endP + 1 && start == end + 1) return true;
        if ((startP > endP && start <= end) || (startP <endP && start > end)) return false;

        char ch = pattern.charAt(startP);
        String matched = map[ch - 'a'];
        if (matched != null) {
            int count = matched.length();
            return start + count <= end + 1 && matched.equals(str.substring(start, start + count))
                    && wordPatternMatch(pattern, str, map, set, start + matched.length(), end, startP + 1, endP)  ;
        } else {
            int endPoint = end;
            for(int i = endP; i > startP; i--) {
                endPoint -= map[pattern.charAt(i) - 'a'] == null ? 1 : map[pattern.charAt(i) - 'a'].length();
            }
            for(int i = start; i <= endPoint; i++) {
                matched = str.substring(start, i + 1);
                if (set.contains(matched)) continue;

                map[ch - 'a'] = matched;
                set.add(matched);

                if (wordPatternMatch(pattern, str, map, set, i + 1, end, startP + 1, endP)) return true;
                else {
                    map[ch - 'a'] = null;
                    set.remove(matched);
                }
            }

            return false;
        }
    }
}