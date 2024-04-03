package com.wjm.question.redbook;

import java.util.Arrays;

public class HongFans {
    int cnt;
    int ans = -1;

    int minAccount(int n, int x, int[] fans) {
        Arrays.sort(fans);
        dfs(true, fans, fans.length - 1, x);
        return ans;
    }

    void dfs(boolean multi, int[] fans, int pos, int need) {
        if (need == 0) {
            if (ans == -1) {
                ans = cnt;
            } else {
                ans = Math.min(ans, cnt);
            }
        }
        for (int i = pos; i >= 0; i--) {
            if (fans[i] / 2 > need) continue;
            if (fans[i] <= need) {
                if (multi) {
                    cnt++;
                    dfs(false, fans, i - 1, need - fans[i]);
                    cnt--;
                }
                cnt++;
                dfs(multi, fans, i - 1, need - fans[i] / 2);
                cnt--;
            }
            if (fans[i] > need && fans[i] / 2 <= need) {
                cnt++;
                dfs(multi, fans, i - 1, need - fans[i] / 2);
                cnt--;
            }
        }
    }

    public static void main(String[] args) {
        HongFans q = new HongFans();
        System.out.println(q.minAccount(5, 14, new int[]{1,2,3,4,10}));
    }
}
