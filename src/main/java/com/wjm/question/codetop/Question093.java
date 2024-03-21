package com.wjm.question.codetop;
/*
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author stephen wang
 */
public class Question093 {
    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        func(s, 0, new ArrayList<>());
        return ans;
    }

    void func(String s, int index, List<Integer> nums) {
        if (nums.size() == 4 && index == s.length()) {
            ans.add(nums.stream().map(String::valueOf).collect(Collectors.joining(".")));
        }
        int num = 0;
        int length = nums.size();
        while (length < 4 && num <= 255 && index < s.length()) {

            if (num == 0 && s.charAt(index) == '0') {
                index++;
                nums.add(0);
                func(s, index, nums);
                nums.remove(nums.size() - 1);
                break;
            } else {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
                if (num <= 255) {
                    nums.add(num);
                    func(s, index, nums);
                    nums.remove(length);
                }
            }

        }
    }

    public static void main(String[] args) {
        Question093 q = new Question093();
        List<String> strings = q.restoreIpAddresses("101023");
        strings.forEach(System.out::println);
    }
}
