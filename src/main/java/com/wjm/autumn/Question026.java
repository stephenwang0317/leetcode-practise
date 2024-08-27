package com.wjm.autumn;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数
 */
public class Question026 {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        boolean f = false;
        if (n < 0) {
            n *= -1;
            f = true;
        }
        double ans = 1.0;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            n = n >>> 1;
            x = x * x;
        }
        return f ? 1 / ans : ans;
    }

    public static void main(String[] args) {
        Question026 q = new Question026();
        System.out.println(q.myPow(2.0, -2147483648));
    }
}
