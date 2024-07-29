package com.wjm.question.huawei;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String pokeString = scanner.nextLine();
        String[] pokes = pokeString.split(" ");

        ArrayDeque<String> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.size() < 2) {
                s.offerLast(pokes[i]);
                continue;
            }
            String c = pokes[i];
            String b = s.pollLast(), a = s.peekLast();
            if (c.equals(b) && c.equals(a)) {
                s.pollLast();
            } else {
                s.offerLast(b);
                s.offerLast(c);
            }
        }
        if (s.size()==0) System.out.println(0);
        else {
            System.out.print(s.pollFirst());
            while (!(s.size()==0)){
                System.out.print(" " + s.pollFirst());
            }
        }
    }
}
