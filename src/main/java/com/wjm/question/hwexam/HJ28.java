package com.wjm.question.hwexam;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            if (x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }


    }
}
