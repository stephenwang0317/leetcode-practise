package com.wjm.autumn;

public class NewCoderDp02 {
    public int jumpFloor(int number) {

        int a = 1, b = 2;
        for (int i = 0; i < number - 2; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String[] args) {
        NewCoderDp02 q = new NewCoderDp02();
        System.out.println(q.jumpFloor(7));
    }
}
