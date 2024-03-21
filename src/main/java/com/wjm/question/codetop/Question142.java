package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null){
            return null;
        }

        fast = fast.next;
        if (fast == null) {
            return null;
        }
        fast = fast.next;
        slow = slow.next;

        int slowStep = 1, fastStep = 2;
        while (fast != null && slow != fast) {
            fast = fast.next;
            fastStep++;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            fastStep++;
            slow = slow.next;
            slowStep++;
        }

        if (fast == null) {
            return null;
        }

        ListNode p = head;
        while (head != slow) {
            head = head.next;
            slow = slow.next;

        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(new int[]{3, 2, 0, -4});
        ListNode q = p;
        while (q.next != null) {
            q = q.next;

        }
        q.next = p.next;

        Question142 qu = new Question142();
        qu.detectCycle(p);
    }
}
