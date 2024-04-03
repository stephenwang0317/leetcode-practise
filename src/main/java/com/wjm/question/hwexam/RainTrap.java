package com.wjm.question.hwexam;

public class RainTrap {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += (Math.min(left[i], right[i]) - height[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        RainTrap trap = new RainTrap();
        System.out.println(trap.trap(ints));
    }
}
