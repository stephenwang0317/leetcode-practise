package com.wjm.question.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int[] nums = new int[n];
            int[] sort = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            int notAppear = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
                sort[j] = nums[j];
                if (map.containsKey(nums[j])) {
                    map.put(nums[j], map.get(nums[j]) + 1);
                } else {
                    map.put(nums[j], 1);
                }
            }
            Arrays.sort(sort);
            while (map.containsKey(notAppear)) notAppear++;
            long min = (long) k * notAppear;
            long cur = 0;
            for (int fi = 0; fi < n; fi++) {
                cur += x;
                if (nums[fi] <= notAppear) {
                    int xx = map.get(nums[fi]);
                    if (xx == 1) {
                        map.remove(nums[fi]);
                        notAppear = nums[fi];
                        min = Math.min(min, cur + (long) notAppear * k);
                    } else {
                        map.put(nums[fi], xx - 1);
                    }
                }
            }
            System.out.println(min);
        }
    }

}
