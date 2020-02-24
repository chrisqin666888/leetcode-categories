package Tree_BFS.P1161_Maximum_Level_Sum_of_a_binary_Tree;

import Tree_BFS.TreeNode;

import java.util.*;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        int max_Val = Integer.MIN_VALUE;
        int max_level = 0;
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            level++;
            int sum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur_node = queue.poll();
                sum += cur_node.val;

                if (cur_node.left != null) queue.offer(cur_node.left);
                if (cur_node.right != null) queue.offer(cur_node.right);
            }
            if (sum > max_Val) {
                max_level = level;
                max_Val = sum;
            }
        }
        return max_level;
    }
}
