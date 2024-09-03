package com.wjm.everyday;

/**
 * 2708. 一个小组的最大实力值
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。
 * 老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，
 * 如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，
 * 那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik] 。
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 */
public class Everyday0903 {
    public long maxStrength(int[] nums) {
        long max = 0L;
        int positive = 0, negative = 0, zero = 0;
        int maxPos = 0, maxNeg = -10;
        for (int num : nums) {
            if (num == 0) zero++;
            else if (num > 0) {
                positive++;
                maxPos = Math.max(maxPos, num);
            } else {
                negative++;
                maxNeg = Math.max(maxNeg, num);
            }
        }
        if (positive == 0 && negative < 2) {
            if (zero > 0) return 0;
            else {
                return nums[0];
            }
        }
        long mul = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) mul *= nums[i];
        }
        if (mul > 0) return mul;
        else {
            mul = mul / maxNeg;
            return mul;
        }

    }

    public static void main(String[] args) {

    }
}
