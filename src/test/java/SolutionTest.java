import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private ListNode input1;
    private int input2;
    private ListNode expected;
    private Solution soln = new Solution2();

    public SolutionTest(ListNode input1, int input2, ListNode out) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = out;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {create(new int[]{1,2,3,4,5}), 2, create(new int[]{1,2,3,5})},
//                {create(new int[]{1}), 1, null},
//                {create(new int[]{1,2}), 1, create(new int[]{1})},
//                {create(new int[]{1,2}), 2, create(new int[]{2})}
        });
    }

    static ListNode create(int[] nums) {
        if (nums.length > 0) {
            ListNode head = new ListNode(nums[0]);
            ListNode p = head;
            for (int i = 1; i < nums.length; i++) {
                p.next = new ListNode(nums[i]);
                p = p.next;
            }
            return head;
        } else {
            return null;
        }
    }

    @Test
    public void testRemoveNth() {
        assertTrue(verifyEquals(expected, soln.removeNthFromEnd(input1, input2)));
    }

    private boolean verifyEquals(ListNode expected, ListNode actual) {
        ListNode p1 = expected, p2 = actual;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                return false;
            }
        }
        return true;
    }
}