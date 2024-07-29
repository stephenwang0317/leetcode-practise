package com.wjm.question.meituan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));

        int ans =0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < k) {
                ans++;
                k-=Math.abs(nums[i]);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
