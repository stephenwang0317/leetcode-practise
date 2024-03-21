package com.wjm.question.leetcode;

import com.wjm.data.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author stephen wang
 */
public class Question2 {
    //public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //    int carry = 0;
    //    ListNode head = new ListNode();
    //    ListNode p = head;
    //    while (l1 != null && l2 != null) {
    //        int x = l1.val + l2.val + carry;
    //        l1 = l1.next;
    //        l2 = l2.next;
    //
    //        carry = x >= 10 ? 1 : 0;
    //        x = x >= 10 ? x - 10 : x;
    //
    //        p.next = new ListNode(x);
    //        p = p.next;
    //    }
    //    if (l1 == null) {
    //        while (l2 != null) {
    //            int x = l2.val + carry;
    //            l2 = l2.next;
    //            carry = x >= 10 ? 1 : 0;
    //            x = x >= 10 ? x - 10 : x;
    //
    //            p.next = new ListNode(x);
    //            p = p.next;
    //        }
    //    } else {
    //        while (l1 != null) {
    //            int x = l1.val + carry;
    //            l1 = l1.next;
    //            carry = x >= 10 ? 1 : 0;
    //            x = x >= 10 ? x - 10 : x;
    //
    //            p.next = new ListNode(x);
    //            p = p.next;
    //        }
    //    }
    //    if (carry > 0) {
    //        p.next = new ListNode(carry);
    //    }
    //    return head.next;
    //}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l1;
        ListNode prel1 = new ListNode();
        prel1.next = l1;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + carry;
            carry = x >= 10 ? 1 : 0;
            x = x >= 10 ? x - 10 : x;
            l1.val = x;
            l1 = l1.next;
            prel1 = prel1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = prel1;
            while (l2 != null) {
                int x = l2.val + carry;

                carry = x >= 10 ? 1 : 0;
                x = x >= 10 ? x - 10 : x;
                l2.val = x;
                l1.next = l2;

                l1 = l1.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int x = l1.val + carry;

                carry = x >= 10 ? 1 : 0;
                x = x >= 10 ? x - 10 : x;
                l1.val = x;

                l1 = l1.next;
            }
        }
        if (carry > 0) {
            ListNode p  =head;
            while (p.next!=null) {
                p=p.next;
            }
            p.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(new int[]{9});
        ListNode q = new ListNode(new int[]{9, 9, 9});
        Question2 question2 = new Question2();
        question2.addTwoNumbers(p, q).print();
    }
}
