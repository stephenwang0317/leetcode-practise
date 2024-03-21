package com.wjm.question.codetop;

import com.wjm.data.ListNode;
import com.wjm.data.TreeNode;

import java.util.*;

/**
 * @author stephen wang
 */
public class Question023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }

        ListNode dummy = new ListNode(), tail = dummy;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            tail.next = node;
            tail = tail.next;

            ListNode next = node.next;
            if (next != null) {
                q.offer(next);
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 4, 5});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        ListNode l3 = new ListNode(new int[]{2, 6});
        Question023 q = new Question023();
        ListNode merged = q.mergeKLists(new ListNode[]{l1, l2, l3});
        merged.print();
    }
}
