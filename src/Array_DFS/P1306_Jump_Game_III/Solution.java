package Array_DFS.P1306_Jump_Game_III;
import java.util.*;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int start, Set<Integer> visited) {
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;
        if (visited.contains(start)) return false;
        visited.add(start);
        return dfs(arr, start + arr[start], visited) || dfs(arr, start - arr[start], visited);
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,2,3,0,3,1,2};
        Solution solution = new Solution();
        System.out.println(solution.canReach(input, 5));
    }
}
