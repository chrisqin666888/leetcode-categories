package Tree_Recursion.P654_Maximum_Binary_Tree;

import _utilities.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return buildMBT(nums, 0, nums.length - 1);
    }

    private TreeNode buildMBT(int[] nums, int start, int end) {
        if (start > end) return null;

        int maxIndex = start;
        for(int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildMBT(nums, start, maxIndex - 1);
        root.right = buildMBT(nums, maxIndex + 1, end);

        return root;
    }
}
