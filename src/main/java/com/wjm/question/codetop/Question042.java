package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question042 {
    public int trap(int[] height) {
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }

        int ans = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] < height[i - 1]) {
                ans += (height[i - 1] - height[i]);
                height[i] = height[i - 1];
            }
        }
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] < height[i + 1]) {
                ans += (height[i + 1] - height[i]);
                height[i] = height[i + 1];
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Question042 q = new Question042();

        System.out.println(q.trap(height));
    }
}
