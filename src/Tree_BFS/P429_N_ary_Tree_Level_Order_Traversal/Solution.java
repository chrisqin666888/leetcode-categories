package Tree_BFS.P429_N_ary_Tree_Level_Order_Traversal;
import Tree_BFS.Node;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node cur_node = queue.poll();
                temp.add(cur_node.val);
                if (cur_node.children.size() != 0) {
                    for(Node node : cur_node.children) {
                        queue.offer(node);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
