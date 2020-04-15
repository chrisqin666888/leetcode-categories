package Tree_Recursion.P1367_Linked_List_in_Binary_Tree;

import _utilities.TreeNode;

public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return head.val == root.val && (helper(head.next, root.left) || helper(head.next, root.right));
    }
}
