package com.wjm.question.lc75;

import java.util.ArrayList;
import java.util.List;

public class Q216 {
    int[] vis;
    List<List<Integer>> ret;
    List<Integer> tmp;

    public List<List<Integer>> combinationSum3(int k, int n) {
        vis = new int[9];
        ret = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(k, n, 9);
        return ret;
    }

    void dfs(int k, int n, int cur) {
        if (k == 0 && n == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = cur; i >= 1; i--) {
            if (n - i >= 0 && vis[i - 1] == 0) {
                vis[i - 1] = 1;
                tmp.add(i);
                dfs(k - 1, n - i, i - 1);
                tmp.remove(tmp.size() - 1);
                vis[i - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Q216 q = new Q216();
        List<List<Integer>> list = q.combinationSum3(4, 1);
        System.out.println(list);
    }
}
