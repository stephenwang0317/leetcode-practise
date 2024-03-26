package com.wjm.question.codetop;

import java.util.Map;

/**
 * @author stephen wang
 */
public class Question153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        //if (nums[l] < nums[r]) return nums[l];
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[l] && nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] < nums[l] && nums[mid] < nums[r]) {
                r = mid;
            } else {
                return Math.min(nums[l], nums[r]);
            }
        }
        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {
        Question153 m = new Question153();
        System.out.println(m.findMin(new int[]{1, 2}));
    }
}
