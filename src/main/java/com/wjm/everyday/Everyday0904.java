package com.wjm.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Everyday0904 {
    public int countWays(List<Integer> nums) {
        int ans = 0;
        Integer[] array = nums.toArray(new Integer[0]);
        Arrays.sort(array);
        for (int i = 0; i <= nums.size(); i++) {
            if (Arrays.binarySearch(array, i) < 0) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Everyday0904 q = new Everyday0904();
        System.out.println(q.countWays(new ArrayList<>(Arrays.asList(1, 1))));
    }
}
