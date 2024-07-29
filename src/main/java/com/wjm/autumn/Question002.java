package com.wjm.autumn;

import com.wjm.data.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Question002 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head!=null) {
            ListNode t= head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = t;
        }
        return dummy.next;
    }
}
