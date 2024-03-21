package com.wjm.question.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question046 {
    int[] map;
    int[] nums;
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        map = new int[nums.length];
        this.nums = nums;
        Arrays.fill(map, 0);
        List<Integer> sub = new ArrayList<>();

        dfs(sub, 0);

        return ans;
    }

    void dfs(List<Integer> sub, int len) {
        if (len == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(sub);
            ans.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (map[i] == 1) {
                continue;
            }
            map[i] = 1;
            sub.add(nums[i]);

            dfs(sub, len + 1);

            map[i] = 0;
            sub.remove(len);
        }
    }

    public static void main(String[] args) {
        Question046 q = new Question046();
        List<List<Integer>> permute = q.permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }
}
