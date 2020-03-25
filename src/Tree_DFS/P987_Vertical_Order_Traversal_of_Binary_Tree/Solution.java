package Tree_DFS.P987_Vertical_Order_Traversal_of_Binary_Tree;
import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeSet<int[]>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0, map);
        for(int key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for(int[] values : map.get(key)) temp.add(values[0]);
            res.add(temp);
        }
        return res;
    }

    private void dfs(TreeNode root, int order, int level, Map<Integer, TreeSet<int[]>> map) {
        if (root == null) return;
        if (!map.containsKey(order)) {
            map.put(order, new TreeSet<int[]>((a, b) ->a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
        }
        map.get(order).add(new int[]{root.val, level});
        dfs(root.left, order - 1, level + 1, map);
        dfs(root.right, order + 1, level + 1, map);
    }
}
