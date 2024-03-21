package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question141 {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode fast = head, slow = head;
        do {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        } while (fast != null && fast != slow);
        return fast != null;
    }
}
