package Backtracking.P282_Expression_Add_Operators;
import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if (pos == num.length()) {
            if (target == prev) {
                res.add(sb.toString());
                return;
            }
        }

        for(int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) break;

            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                dfs(res, sb.append(cur), num, i + 1, target, cur, cur);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(cur), num, i + 1, target, prev + cur, cur);
                sb.setLength(len);

                dfs(res, sb.append("-").append(cur), num, i + 1, target, prev - cur, -cur);
                sb.setLength(len);

                dfs(res, sb.append("*").append(cur), num, i + 1, target, prev - multi + multi * cur, multi * cur);
                sb.setLength(len);
            }
        }
    }
}
