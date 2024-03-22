package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question21_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), p = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }
        while (list2!=null){
            p.next = list2;
            p = p.next;
            list2 = list2.next;
        }
        p.next = null;
        return head.next;
    }
}
