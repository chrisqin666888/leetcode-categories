package LinkedList.P2_Add_Two_Numbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            int digit = sum % 10;
            carry = sum / 10;
            res.next = new ListNode(digit);
            res = res.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) res.next = new ListNode(carry);
        return dummy.next;
    }
}
