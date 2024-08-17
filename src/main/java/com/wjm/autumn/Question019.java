package com.wjm.autumn;

import com.wjm.data.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right.
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表.
 */
public class Question019 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right + 1; i++) {
            end = end.next;
        }

        ListNode p = pre.next;
        pre.next = end;
        while (p != end) {
            ListNode t = p.next;
            p.next = pre.next;
            pre.next = p;
            p = t;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question019 q = new Question019();
        ListNode l = new ListNode(new int[]{1, 2, 3, 4, 5});
        q.reverseBetween(l, 2, 4).print();
    }
}
