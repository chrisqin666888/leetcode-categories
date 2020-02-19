package Backtracking.P216_Combination_Sum_III;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) return result;
        backtrack(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int start_Index, int k , int n) {
        if (n == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start_Index; i <= 9; i++) {
            if (temp.size() > k || n == 0) break;
            temp.add(i);
            backtrack(result, temp, i + 1, k , n - i);
            temp.remove(temp.size() - 1);
        }
    }
}
