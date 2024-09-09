package com.wjm.question.pdd;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        char[] ss = str.toCharArray();
        int ans = 0;
        for (int i = 0; i < ss.length - 1; i++) {
            int tmp = (ss[i] == 'A' ? 1 : -1);
            for (int j = i + 1; j < ss.length; j++) {
                tmp += (ss[j] == 'A' ? 1 : -1);
                if (tmp == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        System.out.println(ans);
    }
}
