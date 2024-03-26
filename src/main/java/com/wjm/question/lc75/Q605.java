package com.wjm.question.lc75;

public class Q605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (i - 1 >= 0) flowerbed[i - 1] = 2;
                if (i + 1 < flowerbed.length) flowerbed[i + 1] = 2;
            }
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1 || flowerbed[i] == 2) continue;
            n--;
            if (i - 1 >= 0) flowerbed[i - 1] = 2;
            if (i + 1 < flowerbed.length) flowerbed[i + 1] = 2;
        }
        return n <= 0;
    }
}
