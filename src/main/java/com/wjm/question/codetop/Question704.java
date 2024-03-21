package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <=r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0};
        Question704 q = new Question704();
        System.out.println(q.search(nums, 0));
    }
}
