package com.wjm.everyday;

import com.wjm.data.ListNode;

public class Everyday0909 {
    public ListNode mergeNodes(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode p = head.next, q = listNode;
        int x = 0;
        while (p != null) {
            if (p.val == 0) {
                q.next = new ListNode(x);
                q = q.next;
                x = 0;
                p=p.next;
            } else {
                x += p.val;
                p = p.next;
            }
        }
        return listNode.next;
    }
}
