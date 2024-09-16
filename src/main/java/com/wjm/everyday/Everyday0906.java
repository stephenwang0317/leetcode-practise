package com.wjm.everyday;

public class Everyday0906 {
    public int maximumLength(int[] nums, int k) {
        int l = 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 1; r < nums.length; r++) {
            cur += (nums[r] == nums[r - 1]) ? 0 : 1;
            while (cur > k) {
                l++;
                cur -= (nums[l] == nums[l - 1]) ? 0 : 1;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Everyday0906 q = new Everyday0906();
        int i = q.maximumLength(new int[]{1, 2, 1, 1, 3}, 2);
        System.out.println(i);
    }
}
