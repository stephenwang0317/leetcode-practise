package com.wjm.question.codetop;

import com.wjm.data.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * */

/**
 * @author stephen wang
 */
public class Question025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(), p = dummy;
        dummy.next = head;

        while (p != null) {
            ListNode t = p;
            for (int i = 0; i < k; i++) {
                p = p.next;
                if (p == null) {
                    break;
                }
            }
            if (p == null) {
                break;
            }
            //t.next = null;
            ListNode nextHead = p.next;
            p.next = null;
            List<ListNode> rev = rev(t.next);
            t.next = rev.get(0);
            rev.get(1).next = nextHead;
            p = rev.get(1);
        }
        return dummy.next;
    }

    List<ListNode> rev(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = head;
        while (head != null) {
            ListNode t = head;
            head = head.next;
            t.next = dummy.next;
            dummy.next = t;
        }
        return new ArrayList<>(Arrays.asList(dummy.next, tail));
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(new int[]{1, 2, 3, 4, 5});
        Question025 question025 = new Question025();

        //l.print();
        //List<ListNode> rev = question025.rev(l);
        //rev.get(1).print();
        l.print();
        ListNode listNode = question025.reverseKGroup(l, 2);
        listNode.print();
    }
}
