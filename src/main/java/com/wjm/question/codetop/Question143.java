package com.wjm.question.codetop;

import com.wjm.data.ListNode;

import java.util.List;

/**
 * @author stephen wang
 */
public class Question143 {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        ListNode middle = slow.next;
        slow.next = null;

        ListNode dummy = new ListNode();
        while (middle != null) {
            ListNode t = middle.next;
            middle.next = dummy.next;
            dummy.next = middle;
            middle = t;
        }
        middle = dummy.next;

        ListNode h = head;
        while (middle != null) {
            ListNode t = middle.next;
            ListNode x = h.next;

            middle.next = h.next;
            h.next = middle;

            middle = t;
            h = x;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(new int[]{1, 2, 3, 4, 5});
        Question143 q = new Question143();

        l.print();
        q.reorderList(l);
        l.print();
    }
}
