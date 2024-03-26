package com.wjm.question.lc75;

public class Q283 {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        for (int i = 0; i < cnt; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    public static void main(String[] args) {
        Q283 q = new Q283();
        q.moveZeroes(new int[]{0,1,0,3,12});

    }
}
