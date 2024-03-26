package com.wjm.question.lc75;

import java.util.ArrayList;
import java.util.List;

public class Q1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > max) max = candy;
        }
        List<Boolean> ret = new ArrayList<>();
        for (int candy :
                candies) {
            ret.add(candy + extraCandies >= max);
        }
        return ret;
    }
}
