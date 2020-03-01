package Tree_Recursion.P589_N_ary_Tree_Preorder_Traversal;
import _utilities.Node;

import java.util.*;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        result.add(root.val);
        if (root.children.isEmpty()) return;
        for(Node child : root.children) {
            preorder(child, result);
        }
    }
}
