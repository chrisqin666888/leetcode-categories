package Tree_Recursion.P106_Construct_Binary_Tree_From_Inorder_and_Postorder_Traversal;

import _utilities.TreeNode;

public class Solution_No_HashMap {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 ||
                postorder == null || postorder.length == 0) {
            return null;
        }

        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int index, int start, int end) {
        if (start > end || index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int i;
        for( i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.right = helper(inorder, postorder, index - 1,  i + 1, end);
        root.left = helper(inorder, postorder, index - (end - i + 1), start, i - 1);
        return root;
    }
}
