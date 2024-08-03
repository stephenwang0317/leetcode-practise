package com.wjm.autumn;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Question013 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            if (nums[l] > nums[r]) {
                if (nums[mid] > nums[l]) {
                    if (nums[mid] > target) {
                        if (nums[l] < target) r = mid;
                        else l = mid;
                    }
                    else l = mid;
                } else {
                    if (nums[mid] > target) r = mid;
                    else {
                        if (nums[r] < target) {
                            r = mid;
                        } else {
                            l = mid;
                        }
                    }
                }
            } else {
                if (nums[mid] > target) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    public static void main(String[] args) {
        Question013 question013 = new Question013();
        int search = question013.search(new int[]{1,3}, 2);
        System.out.println(search);
    }
}
