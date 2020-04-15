package LinkedList.P24_Swap_Nodes_in_Pairs;

import _utilities.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while(current.next != null && current.next.next != null) {
            swap(current);
            current = current.next.next;
        }

        return dummy.next;
    }

    private void swap(ListNode pre) {
        ListNode dummy = pre.next;
        pre.next = dummy.next;
        dummy.next = dummy.next.next;
        pre.next.next = dummy;
    }
}
