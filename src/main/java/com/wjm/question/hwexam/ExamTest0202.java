package com.wjm.question.hwexam;

import java.util.Scanner;

public class ExamTest0202 {
    static int[] pre;
    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        pre = new int[n];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
            nums[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map[i][j] > 0) {
                    int preI = find(i), preJ = find(j);
                    if (preI != preJ) {
                        pre[i] = j;
                        nums[preJ] += (nums[preI] + map[i][j]);
                    } else {
                        nums[preJ] += nums[preI];
                    }
                }
            }
        }
        boolean start = true;
        for (int i = 0; i < n; i++) {
            if(pre[i]==i) {
                if (!start) {
                    System.out.print(" ");
                } else {
                    start = false;
                }
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }

    static int find(int x) {
        if (x == pre[x]) return x;
        else return find(pre[x]);
    }

}
