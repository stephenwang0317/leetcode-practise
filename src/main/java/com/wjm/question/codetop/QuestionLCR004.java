package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class QuestionLCR004 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += ((num >> i) & 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            bits[i] = bits[i] % 3;
            ans = ans | (bits[i] << i);
        }
        return ans;
    }
}
