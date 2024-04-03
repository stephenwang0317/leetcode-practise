package com.wjm.question.hwexam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split("\\.");
        String[] b = in.nextLine().split("\\.");
        String[] c = in.nextLine().split("\\.");
        System.out.println(func(a, b, c));
    }

    static int func(String[] a, String[] b, String[] c) {
        List<Integer> mask = Arrays.stream(a).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ip01 = Arrays.stream(b).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ip02 = Arrays.stream(c).map(Integer::parseInt).collect(Collectors.toList());
        boolean zeroAppear = false;
        for (int i = 0; i < 4; i++) {
            int x = mask.get(i);
            if (zeroAppear && x != 0) {
                return 1;
            }
            if (x != 0 && x != 255 && x != 254 && x != 252 && x != 248 && x != 240 && x != 224 && x != 192 && x != 128) {
                return 1;
            } else if (x == 0 || x == 254 || x == 252 || x == 248 || x == 240 || x == 224 || x == 192 || x == 128) {
                zeroAppear = true;
            }
        }
        for (int x : ip01) {
            if (x < 0 || x > 255) {
                return 1;
            }
        }
        for (int x : ip02) {
            if (x < 0 || x > 255) {
                return 1;
            }
        }
        int[] ans1 = new int[4];
        int[] ans2 = new int[4];
        for (int i = 0; i < 4; i++) {
            ans1[i] = mask.get(i) & ip01.get(i);
            ans2[i] = mask.get(i) & ip02.get(i);
        }
        for (int i = 0; i < 4; i++) {
            if (ans1[i] != ans2[i])
                return 2;
        }
        return 0;
    }
}
// 2*(1/N * 1/N-1)