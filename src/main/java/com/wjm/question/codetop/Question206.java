package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question206 {

    public ListNode reverseList(ListNode head) {
        ListNode dump = new ListNode();

        while (head != null) {
            ListNode p = head;
            head = head.next;

            p.next = dump.next;
            dump.next = p;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(new int[]{1,2,3,4,5});
        l.print();
        Question206 codeTop002 = new Question206();
        codeTop002.reverseList(l).print();
    }
}