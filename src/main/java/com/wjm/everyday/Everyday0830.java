package com.wjm.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 */
public class Everyday0830 {
    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        List<int[]> arr = new ArrayList<>();
        int x = nums[0];
        while (x != 0) {
            int[] ints = new int[10];
            ints[x % 10]++;
            x /= 10;
            arr.add(ints);
        }

        for (int i = 1; i < nums.length; i++) {
            int k = nums[i];
            int cur = 0;
            while (k != 0) {
                int[] ints = arr.get(cur);
                ints[k % 10]++;
                k /= 10;
                cur++;
            }
        }

        for (int[] ints : arr) {
            int sum = Arrays.stream(ints).sum();
            for (int i = 0; i < 10; i++) {
                if (ints[i] == 0) continue;
                ans += ((long) ints[i] * (long) (sum - ints[i]));
                sum -= ints[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Everyday0830 q = new Everyday0830();
        System.out.println(q.sumDigitDifferences(new int[]{13, 23, 12}));
    }
}
