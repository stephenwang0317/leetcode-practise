package com.wjm.question.meituan2;

import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int k = in.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[][] map = new int[n][n];
        if (k > 0) {
            extractedMax(n, nums, k, map);
        } else {
            extractedMin(n, nums, k, map);
        }
        if (k > 0) {
            extractedMin(n, nums, k, map);
        } else {
            extractedMax(n, nums, k, map);
        }
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        System.out.println(ans);
    }

    private static void extractedMin(int n, int[] nums, int k, int[][] map) {
        int min = Integer.MAX_VALUE, minI = -1, minJ = -1;
        for (int i = 0; i < n; i++) {
            map[i][i] = nums[i];
            if (map[i][i] < min) {
                min = map[i][i];
                minI = i;
                minJ = i;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map[i][j] = map[i][j - 1] + nums[j];
                if (map[i][j] < min) {
                    min = map[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }
        for (int i = minI; i < minJ; i++) {
            nums[i] *= k;
        }
    }

    private static void extractedMax(int n, int[] nums, int k, int[][] map) {
        int max = Integer.MIN_VALUE, maxI = -1, maxJ = -1;
        for (int i = 0; i < n; i++) {
            map[i][i] = nums[i];
            if (map[i][i] > max) {
                max = map[i][i];
                maxI = i;
                maxJ = i;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map[i][j] = map[i][j - 1] + nums[j];
                if (map[i][j] > max) {
                    max = map[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        for (int i = maxI; i < maxJ; i++) {
            nums[i] *= k;
        }
    }
}
