package com.wjm.question.codetop;

/*
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * */

/**
 * @author stephen wang
 */
public class Question121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
            if (price < minPrice) {
                minPrice = price;
            }
        }
        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {
        Question121 question121 = new Question121();
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(question121.maxProfit(a));
    }
}
