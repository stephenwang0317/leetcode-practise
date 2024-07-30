package com.wjm.autumn;

import java.util.*;

public class Question006 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int c = nums[i] + nums[l] + nums[r];
                if (c == 0) {
                    ret.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < r && (nums[l - 1] == nums[l])) l++;
                    while (l < r && (nums[r + 1] == nums[r])) r--;
                } else if (c < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Question006 q = new Question006();
        List<List<Integer>> lists = q.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        lists.forEach(a -> System.out.println(a));
    }
}
