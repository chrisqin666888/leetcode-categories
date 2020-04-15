package Tree_Recursion.P95_Unique_Binary_Search_Tree;

import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if(start > end) {
            trees.add(null);
            return trees;
        }

        // pick a root
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for(TreeNode l : left) {
                for(TreeNode r: right) {
                    TreeNode cur_tree = new TreeNode(i);
                    cur_tree.left = l;
                    cur_tree.right = r;
                    trees.add(cur_tree);
                }
            }
        }

        return trees;
    }
}
