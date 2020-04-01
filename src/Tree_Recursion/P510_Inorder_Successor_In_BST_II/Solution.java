package Tree_Recursion.P510_Inorder_Successor_In_BST_II;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class Solution {
    public Node inorderSuccessor(Node x) {
        if(x == null) return null;

        if(x.right != null) {
            x = x.right;

            while(x != null && x.left != null) {
                x = x.left;
            }

            return x;
        }

        while(x != null)
        {
            if(x.parent == null)
                return null;

            if(x.parent.left == x)
                return x.parent;

            else {
                x = x.parent;
            }

        }

        return x;
    }
}