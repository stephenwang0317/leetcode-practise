package com.wjm.question.leetcode;

import java.util.ArrayList;

/**
 * @author stephen wang
 */
public class Question9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (x != 0) {
            arrayList.add(x % 10);
            x /= 10;
        }
        int i = 0, j = arrayList.size() - 1;
        while (i < j) {
            if (!arrayList.get(i).equals(arrayList.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Question9 question9 = new Question9();
        System.out.println(question9.isPalindrome(1211));
    }
}
