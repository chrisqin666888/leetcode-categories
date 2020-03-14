package Tree_DFS.P652_Find_Duplicate_Subtree;
import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public List findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postorder(root, new HashMap<>(), res);

        return res;
    }

    private String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";

        String serial = postorder(cur.left, map, res) + "," + postorder(cur.right, map, res) + "," + cur.val;
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(cur);
        }

        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
