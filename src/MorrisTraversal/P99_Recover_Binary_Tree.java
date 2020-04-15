package MorrisTraversal;

import _utilities.TreeNode;

public class P99_Recover_Binary_Tree {
    public void recoverTree(TreeNode root) {
        TreeNode firstToSwap = null;
        TreeNode secondToSwap = null;
        boolean firstTime = true;
        TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

        while(root != null) {
            // check if current node has a left child
            // if it does, we traversal to the deepest RIGHT child
            if (root.left != null) {
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root) {
                    temp = temp.right;
                }

                // we reach the RIGHT most child of this left current node,
                // then we let this node pointing back to the current root.
                // and move to the next left child of this current node, aka it's like we
                // build a bridge. if we find a loop, aka we find that the next right is
                // the root, we know we have visited this node before, we set it back to null
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    temp.right = null;
                    // visit root.val
                    if (prevNode.val > root.val && firstTime) {
                        firstToSwap = prevNode;
                        firstTime = false;
                    }
                    if (prevNode.val > root.val && !firstTime) {
                        secondToSwap = root;
                    }
                    prevNode = root;
                    root = root.right;
                }
            } else {
                // visit root.val
                if (prevNode.val > root.val && firstTime) {
                    firstToSwap = prevNode;
                    firstTime = false;
                }
                if (prevNode.val > root.val && !firstTime) {
                    secondToSwap = root;
                }
                prevNode = root;
                root = root.right;
            }
        }

        if (firstToSwap != null && secondToSwap != null) {
            int temp = firstToSwap.val;
            firstToSwap.val = secondToSwap.val;
            secondToSwap.val = temp;

        }
    }
}
