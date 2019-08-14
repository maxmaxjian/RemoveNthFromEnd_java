public class Solution1 implements Solution {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = head;
        int i = 1;
        while (i < n+1 && p != null) {
            p = p.next;
            i++;
        }

        ListNode prev = head;
        while (p != null) {
            prev = prev.next;
            p = p.next;
        }
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        } else if (prev != null) {
            prev.next = null;
        } else {
            return head.next;
        }

        return head;
    }
}
