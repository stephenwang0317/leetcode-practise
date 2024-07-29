package com.wjm.question.other;

public class FastPow {
    static long fastPow(int n, int x, int mod) {
        if (x == 0)
            return 1;
        else if (x % 2 == 0) {
            return fastPow((n % mod) * (n % mod), x / 2, mod) % mod;
        } else {
            return (n % mod) * fastPow((n % mod) * (n % mod), (x - 1) / 2, mod) % mod;
        }
    }

    static long normalPow(int n, int x, int mod) {
        long ans = 1;
        for (int i = 0; i < x; i++) {
            ans *= n;
            ans = ans % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(fastPow(7, 99, 10000));
        long l1 = System.currentTimeMillis();
        System.out.println(normalPow(7, 99, 10000));
        long l2 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(l2-l1);
    }
}
