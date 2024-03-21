package com.wjm.data;

/**
 * @author stephen wang
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] nums) {
        this(nums[0]);
        ListNode p = this;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
    }

    public void print() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print(" -> ");
            this.next.print();
        }else {
            System.out.print("\n");
        }

    }
}
