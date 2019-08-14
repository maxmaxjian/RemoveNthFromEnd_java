public class Solution2 implements Solution {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        if (len == n) {
            return head.next;
        } else {
            int i = 1;
            p = head;
            while (i < len-n) {
                p = p.next;
                i++;
            }
            if (p.next != null) {
                p.next = p.next.next;
            } else {
                p.next = null;
            }
            return head;
        }
    }
}
