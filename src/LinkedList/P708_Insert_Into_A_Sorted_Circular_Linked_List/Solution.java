package LinkedList.P708_Insert_Into_A_Sorted_Circular_Linked_List;


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


public class Solution {
    public Node insert(Node head, int insertVal) {
        Node nodeToInsert = new Node(insertVal, null);

        // case 1
        if (head == null) {
            nodeToInsert.next = nodeToInsert;
            return nodeToInsert;
        }

        Node dummy = head;
        while(true) {
            // case 2 - 4
            if ((insertVal >= dummy.val && insertVal <= dummy.next.val)
            || (dummy.next.val < dummy.val && (insertVal >= dummy.val || insertVal <= dummy.next.val))
            || dummy.next == head) {
                nodeToInsert.next = dummy.next;
                dummy.next = nodeToInsert;
                break;
            }
            dummy = dummy.next;
        }

        return head;
    }
}
