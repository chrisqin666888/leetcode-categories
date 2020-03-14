package Backtracking.P366_Find_Leaves_of_binary_tree;
import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        backtrack(result, root);

        return result;
    }

    private int backtrack(List<List<Integer>> result, TreeNode root) {
        if (root == null) return -1;

        int leftLevel = backtrack(result, root.left);
        int rightLevel = backtrack(result, root.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        return level;
    }
}
