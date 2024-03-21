package com.wjm.question.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        loop1:
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    do {
                        j++;
                    } while (j > i && j < k && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    } while (k < nums.length && j < k && nums[k] == nums[k + 1]);
                } else if (t < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question015 q = new Question015();
        List<List<Integer>> lists = q.threeSum(new int[]{0, 0, 0});
        lists.forEach(System.out::println);
    }
}
