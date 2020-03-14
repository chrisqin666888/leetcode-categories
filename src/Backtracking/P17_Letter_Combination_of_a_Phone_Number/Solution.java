package Backtracking.P17_Letter_Combination_of_a_Phone_Number;
import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        dfs("", res, digits, 0, map);

        return res;
    }

    private void dfs(String cur, List<String> res, String digits, int curIndex, Map<Character, char[]> map) {
        if (curIndex == digits.length()) {
            res.add(cur);
        } else {
            char c = digits.charAt(curIndex);
            if (map.containsKey(c)) {
                for(char ch : map.get(c)) {
                    dfs(cur + ch, res, digits, curIndex + 1, map);
                }
            }
        }
    }
}
