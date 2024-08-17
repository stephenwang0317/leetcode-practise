package com.wjm.question.meituan2;

import java.util.Arrays;
import java.util.Scanner;

public class Question02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }

        long add = 0;
        while ((sum + add) % n != 0) add++;
        int higher = (int) ((sum + add) / n);
        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i < add) {
                cnt += Math.abs(higher - 1 - nums[i]);
            } else {
                cnt += Math.abs(higher - nums[i]);
            }
        }
        System.out.println(cnt / 2);
    }
}
