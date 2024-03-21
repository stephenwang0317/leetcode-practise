package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;

        }
        if (q == null) {
            return head.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;

        }
        p.next = p.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(new int[]{1, 2});
        Question019 q = new Question019();

        p.print();
        q.removeNthFromEnd(p, 2).print();
    }
}
