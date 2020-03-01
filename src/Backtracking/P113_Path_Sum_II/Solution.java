package Backtracking.P113_Path_Sum_II;
import _utilities.TreeNode;

import java.util.*;


public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        backtrack(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null) return;

        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(temp));
        } else {
            backtrack(root.left, sum - root.val, temp, result);
            backtrack(root.right, sum - root.val, temp, result);
        }
        temp.remove(temp.size() - 1);
    }


}
