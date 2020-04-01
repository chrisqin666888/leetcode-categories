package Tree_Recursion.P899_Construct_binary_tree_from_preorder_and_postorder_traversal;

import _utilities.TreeNode;

public class Solution {
    int preIndex = 0, postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[postIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[postIndex])
            root.right = constructFromPrePost(pre, post);
        postIndex++;
        return root;
    }
}
