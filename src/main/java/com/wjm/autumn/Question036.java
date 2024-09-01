package com.wjm.autumn;

import com.wjm.utils.InputConverter;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 */
public class Question036 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int begin = bookings[i][0] - 1, end = bookings[i][1] - 1, num = bookings[i][2];
            arr[begin] += num;
            if (end + 1 < n) arr[end + 1] -= num;
        }
        int[] ans = new int[n];
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = cur + arr[i];
            cur = ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Question036 q = new Question036();
        int[][] ints = InputConverter.stringToIntArray("[[1,2,10],[2,3,20],[2,5,25]]");
        int[] ints1 = q.corpFlightBookings(ints, 5);
        System.out.println(Arrays.toString(ints1));
    }
}
