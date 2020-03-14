package Stack.P536_Construct_Binary_Tree_From_String;
import _utilities.TreeNode;

import java.util.*;

public class Solution {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if (c == ')') stack.pop();
            else if (c >= '0' && c <= '9' || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode cur_node = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));

                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = cur_node;
                    } else {
                        parent.left = cur_node;
                    }
                }
                stack.push(cur_node);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.str2tree("4(2(3)(1))(6(5))"));
    }
}
