package com.wjm.question.codetop;
/*
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * */

/**
 * @author stephen wang
 */
public class Question033 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Question033 q = new Question033();
        //int[] nums = new int[]{3,1};
        System.out.println(q.search(nums, 1));
        System.out.println(q.search(nums,4));
        System.out.println(q.search(nums,5));
        System.out.println(q.search(nums,6));
        System.out.println(q.search(nums,7));
        System.out.println(q.search(nums,0));
        System.out.println(q.search(nums,1));
        System.out.println(q.search(nums,2));
        System.out.println(q.search(nums,3));
        System.out.println(q.search(nums,8));
    }
}
