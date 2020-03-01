package Tree_BFS.P742_Closest_Leaf_in_a_Binary_Tree;

import _utilities.TreeNode;
import java.util.*;

public class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        // DFS search for node whose val == k
        TreeNode k_node = dfs(root, k, backMap);
        queue.add(k_node);
        visited.add(k_node);

        while(!queue.isEmpty()){
            TreeNode cur_node = queue.poll();
            if (cur_node.left == null && cur_node.right == null) {
                return cur_node.val;
            }
            if (cur_node.left != null && !visited.contains(cur_node.left)) {
                queue.add(cur_node.left);
                visited.add(cur_node.left);
            }
            if (cur_node.right != null && !visited.contains(cur_node.right)) {
                queue.add(cur_node.right);
                visited.add(cur_node.right);
            }
            if (backMap.containsKey(cur_node) && !visited.contains(backMap.get(cur_node))) {
                queue.add(backMap.get(cur_node));
                visited.add(backMap.get(cur_node));
            }
        }
        return -1;
    }

    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null) return null;
        if (root.val == k) return root;
        TreeNode left = dfs(root.left, k, map);
        if (left != null) {
            map.put(root.left, root);
            return left;
        }
        TreeNode right = dfs(root.right, k, map);
        if (right != null) {
            map.put(root.right, root);
            return right;
        }
        return null;
    }
}
