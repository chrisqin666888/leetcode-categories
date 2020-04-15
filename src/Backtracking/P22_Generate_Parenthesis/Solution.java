package Backtracking.P22_Generate_Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }

        if (open < max) {
            dfs(res, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            dfs(res, cur + ")", open, close + 1, max);
        }
    }
}
