package Array_DFS.P386_Lexicographical_Numbers;
import java.util.*;

public class Solution {
    public List<Integer> lexicalOrder(int N) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            dfs(i, N, result);
        }

        return result;
    }

    private void dfs(int cur, int N, List<Integer> result) {
        if (cur <= N) {
            result.add(cur);
            for(int i = 0; i < 10; i++) {
                if (10 * cur + i <= N) {
                    dfs(10 * cur + i, N, result);
                }
            }
        }
    }
}
