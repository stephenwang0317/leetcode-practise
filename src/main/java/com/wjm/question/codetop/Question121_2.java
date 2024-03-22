package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question121_2 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i : prices) {
            if (i < minPrice) {
                minPrice = i;
            }
            if (i - minPrice > maxProfit) {
                maxProfit = i - minPrice;
            }
        }
        return maxProfit;
    }
}
