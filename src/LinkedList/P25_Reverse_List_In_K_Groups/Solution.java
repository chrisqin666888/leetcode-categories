package LinkedList.P25_Reverse_List_In_K_Groups;

import _utilities.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev != null) {
            prev = reverse(prev, k);
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int k) {
        ListNode last = prev;
        for(int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) return null;
        }

        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while(curr != last) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }
        return tail;
    }
}
