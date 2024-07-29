package com.wjm.question.others;

import java.util.Arrays;

public class Question2 {
    public static int function(int[] a){
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i != a[i])
                return a[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(function(new int[]{3,1,2,4,0,3,2}));
    }
}
