package com.wjm.autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Question012 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] vis = new int[nums.length];
        Arrays.fill(vis, 0);

        func(ans, tmp, 0, vis, nums);

        return ans;
    }

    void func(List<List<Integer>> ans, List<Integer> tmp, int cnt, int[] vis, int[] nums) {
        if (cnt == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 1) continue;

            tmp.add(nums[i]);
            vis[i] = 1;
            func(ans, tmp, cnt + 1, vis, nums);
            vis[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        Question012 q = new Question012();
        List<List<Integer>> permute = q.permute(ints);
        permute.forEach(System.out::println);
    }
}
