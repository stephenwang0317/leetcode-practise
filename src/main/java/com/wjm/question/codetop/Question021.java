package com.wjm.question.codetop;

import com.wjm.data.ListNode;

import java.util.List;

/**
 * @author stephen wang
 */
public class Question021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(), q = p;
        while (list1 != null && list2 != null) {
            ListNode a = list1, b = list2;
            if (a.val > b.val) {
                list2 = list2.next;
                b.next = q.next;
                q.next = b;
                q = q.next;


            } else {
                list1 = list1.next;
                a.next = q.next;
                q.next = a;
                q = q.next;

            }

        }
        if (list1 != null) {
            q.next = list1;
        } else {
            q.next = list2;
        }
        return p.next;
    }

    public static void main(String[] args) {
        Question021 q = new Question021();
        ListNode a = new ListNode(new int[]{5});
        ListNode b = new ListNode(new int[]{1, 2, 4});
        ListNode listNode = q.mergeTwoLists(a, b);

        listNode.print();
    }
}
