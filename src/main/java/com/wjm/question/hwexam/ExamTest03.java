package com.wjm.question.hwexam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ExamTest03 {
    static int function(int min, int max, int[] nums) {
        int[] dp = new int[1001];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i < 1001; i++) {
                dp[i] += dp[i - num];
            }
        }
        int cnt = 0;
        for (int i = min; i <= max; i++) {
            cnt += dp[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt(), max = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(function(min, max, nums));
    }
}
// 400-3
// 500-4