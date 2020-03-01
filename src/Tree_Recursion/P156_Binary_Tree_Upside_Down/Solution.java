package Tree_Recursion.P156_Binary_Tree_Upside_Down;

import _utilities.TreeNode;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        TreeNode trueroot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return trueroot;
    }
}
