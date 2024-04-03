package com.wjm.question.tencent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x != 0) num.offerLast(x);
        }
        System.out.println(func(num, k));

    }

    static int func(ArrayDeque<Integer> nums, int k) {
        if (nums.size() == k) {
            return calSum(nums);
        }
        int ans = 0;
        int cur = 0;
        int segCnt = 0;
        for (int i = 0; !nums.isEmpty() && segCnt <= k; i++) {
            if (nums.size() == k - segCnt) {
                while (!nums.isEmpty()) cur = cur^nums.pollFirst();
                return calSum(nums);
            };
            int x = nums.pollFirst();
            if ((cur ^ x) > x) {
                ans += (cur ^ x);
                segCnt++;

                cur = 0;
            } else {
                cur = (cur ^ x);
            }
        }
        return ans;
    }

    static int calSum(ArrayDeque<Integer> nums) {
        int x = 0;
        for (int i :
                nums) {
            x += i;
        }
        return x;
    }
}

// 1,2,3,4,5