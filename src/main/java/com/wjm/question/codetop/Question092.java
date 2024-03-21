package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(), p = dummy, tail = dummy;
        for (int i = 0; i < left - 1; i++) {
            ListNode t = head.next;
            head.next = null;
            tail.next = head;
            head = t;
            tail = tail.next;
        }

        p = tail;
        boolean flag = false;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode t = head.next;
            head.next = p.next;
            p.next = head;
            if (!flag) {
                tail = head;
                flag = true;
            }
            head = t;
        }

        while (head != null) {
            ListNode t = head.next;
            head.next = null;
            tail.next = head;
            head = t;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(a);

        Question092 q = new Question092();

        listNode.print();
        q.reverseBetween(listNode, 2, 4).print();
        //listNode.print();
    }
}
