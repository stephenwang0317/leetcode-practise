package com.wjm.question.hwexam;

import java.util.*;
import java.util.stream.Collectors;

public class ExamTest01 {
    static int function(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, (old, n) -> old + 1);
        }
        int n = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int key = integerIntegerEntry.getKey(), value = integerIntegerEntry.getValue();
            if (value > cnt) {
                cnt = value;
                n = key;
            }
        }
        if (cnt > nums.length / 2)
            return n;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] split = input.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(function(nums));
    }
}
