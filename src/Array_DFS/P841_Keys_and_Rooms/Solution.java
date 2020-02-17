package Array_DFS.P841_Keys_and_Rooms;
import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(int sub_node: rooms.get(node)) {
                if (!seen[sub_node]) {
                    seen[sub_node] = true;
                    stack.push(sub_node);
                }
            }
        }

        for(boolean node : seen) {
            if (!node) return false;
        }

        return true;
    }
}
