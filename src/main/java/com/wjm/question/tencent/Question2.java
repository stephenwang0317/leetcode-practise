package com.wjm.question.tencent;

import com.wjm.data.ListNode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Question2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param lists ListNode类一维数组
     * @return bool布尔型一维数组
     */
    public boolean[] canSorted(ListNode[] lists) {
        boolean[] booleans = new boolean[lists.length];
        for (int i = 0; i < lists.length; i++) {
            booleans[i] = func(lists[i]);
        }
        return booleans;
    }

    public boolean func(ListNode listNode) {
        int start = listNode.val;
        int cur = start;
        int bfStep = 0;
        boolean step = false;
        ListNode p = listNode;
        while (p.next != null) {
            ListNode next = p.next;
            if (!step) {
                if (next.val > cur) {
                    p = next;
                    cur = next.val;
                } else {
                    p = next;
                    step = true;
                    bfStep = cur;
                    cur = next.val;
                }
            } else {
                if (next.val < cur) {
                    return false;
                } else {
                    if (next.val > bfStep) {
                        return false;
                    }
                }
                p = next;
            }
        }
        if (step && p.val > start) {
            return false;
        }
        return true;
    }

    public boolean function(ListNode listNode) {
        ListNode p = listNode;
        while (p.next != null && p.val < p.next.val) {
            p = p.next;
        }
        if (p.next == null) return true;
        ListNode check = check(p.next);
        if (check == null) return false;
        else return check.val < listNode.val;
    }

    public ListNode check(ListNode listNode) {
        ListNode p = listNode;
        while (p.next != null) {
            if (p.val > p.next.val) return null;
            else {
                p = p.next;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        System.out.println(q.function(new ListNode(new int[]{3, 1})));
        System.out.println(q.function(new ListNode(new int[]{1, 2})));
        System.out.println(q.function(new ListNode(new int[]{99, 100, 299, 150, 151, 152})));
        System.out.println(q.function(new ListNode(new int[]{9, 1, 2, 3, 4, 5})));
    }
}
