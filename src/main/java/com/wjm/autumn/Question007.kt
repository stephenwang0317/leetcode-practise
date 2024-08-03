package com.wjm.autumn


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(-1)
        var l1 = list1
        var l2 = list2
        var p = head
        while (l1 != null && l2 != null) {
            if (l1.`val` > l2.`val`) {
                p.next = l2
                l2 = l2.next
            } else {
                p.next = l1
                l1 = l1.next
            }
            p = p.next ?: ListNode(-1)
        }
        if (l1 == null) {
            while (l2 != null) {
                p.next = l2
                l2 = l2.next
                p = p.next ?: ListNode(-1)
            }

        } else {
            while (l1 != null) {
                p.next = l1
                l1 = l1.next
                p = p.next ?: ListNode(-1)
            }
        }
        return head.next
    }
}