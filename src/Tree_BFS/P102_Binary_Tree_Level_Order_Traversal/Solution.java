package Tree_BFS.P102_Binary_Tree_Level_Order_Traversal;

import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur_node = queue.poll();
                temp.add(cur_node.val);

                if (cur_node.left != null) queue.offer(cur_node.left);
                if (cur_node.right != null) queue.offer(cur_node.right);
            }
            result.add(temp);
        }

        return result;
    }
}
