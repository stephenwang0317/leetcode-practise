package com.wjm.question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author stephen wang
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
