package Tree_Recursion.P106_Construct_Binary_Tree_From_Inorder_and_Postorder_Traversal;

import _utilities.TreeNode;
import java.util.*;

public class Solution_HashMap {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);

    }

    private TreeNode helper(int[] inorder, int inorder_start, int inorder_end,
                            int[] postorder, int post_start, int post_end, Map<Integer, Integer> map) {

        if (post_start > post_end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[post_end]);
        int root_index = map.get(postorder[post_end]);

        TreeNode left = helper(inorder, inorder_start, root_index - 1,
                postorder, post_start, post_start + root_index - inorder_start - 1, map);
        TreeNode right = helper(inorder, root_index + 1, inorder_end,
                postorder, post_start + root_index - inorder_start, post_end - 1, map);

        root.left = left;
        root.right = right;
        return root;
    }
}
