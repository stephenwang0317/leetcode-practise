package com.wjm.autumn;

public class NewCoderDp01 {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        int a = 1, b = 1;
        for (int i = 0; i < n - 2; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String[] args) {
        NewCoderDp01 q = new NewCoderDp01();
        System.out.println(q.Fibonacci(4));
    }
}
