package com.wjm.question.codetop;

import com.wjm.data.ListNode;

/**
 * @author stephen wang
 */
public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p = headA;
        while (p != null) {
            p = p.next;
            lenA++;
        }
        p = headB;
        while (p != null) {
            p = p.next;
            lenB++;
        }
        ListNode startA = headA, startB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                startA = startA.next;
            }
        } else if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                startB = startB.next;
            }
        }

        while (startA != null && startB != null && startA != startB) {
            startA = startA.next;
            startB = startB.next;
        }
        if (startA==null || startB==null){
            return null;
        }else {
            return startA;
        }
    }
}
