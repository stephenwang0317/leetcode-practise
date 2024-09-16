package com.wjm.everyday;

/**
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，
 * 其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * 你可以同时选择两个端点为整数的线段。每个线段的长度都必须是 k 。
 * 你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，
 * 你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 */
public class Everyday0911 {
    public int maximizeWin(int[] prizePositions, int k) {
        int l = prizePositions[0];
        int lPos = 0;
        int cur = 0;
        int ans = 0;
        int finalL = -1, finalR = -1;
        for (int i = 0; i < prizePositions.length; i++) {
            if (prizePositions[i] - l > k) {
                if (cur > ans) {
                    ans = cur;
                    finalL = lPos;
                    finalR = i;
                }
                cur = 0;
                while (l == prizePositions[lPos]) {
                    lPos++;
                }
                l = prizePositions[lPos];
                i--;
            } else {
                cur++;
            }
        }
        if (cur > ans) {
            ans = cur;
            finalL = lPos;
            finalR = prizePositions.length - 1;
        }

        int[] sub = new int[prizePositions.length - ans];
        if (sub.length == 0) {
            return ans;
        }
        int j = 0;
        for (int i = 0; i < prizePositions.length; i++) {
            if (i >= finalL && i < finalR) continue;
            else {
                sub[j] = prizePositions[i];
                j++;
            }
        }

        int ans2 = 0;
        cur = 0;
        l = sub[0];
        lPos = 0;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] - l > k) {
                if (cur > ans2) {
                    ans2 = cur;
                }
                cur = 0;
                while (l == sub[lPos]) {
                    lPos++;
                }
                l = sub[lPos];
                i--;
            } else {
                cur++;
            }
        }
        if (cur > ans2) {
            ans2 = cur;
        }
        return ans + ans2;
    }

    public static void main(String[] args) {
        Everyday0911 q = new Everyday0911();
        int[] ints = {2616, 2618, 2620, 2621, 2626, 2635, 2657, 2662, 2662, 2669, 2671, 2693, 2702, 2713, 2714, 2718, 2730, 2731, 2750, 2756, 2772, 2773, 2775, 2785, 2795, 2805, 2811, 2813, 2816, 2823, 2824, 2824, 2826, 2830, 2833, 2857, 2885, 2898, 2910, 2919, 2928, 2941, 2942, 2944, 2965, 2967, 2970, 2973, 2974, 2975, 2977, 3002, 3007, 3012, 3042, 3049, 3078, 3084, 3089, 3090, 3094, 3097, 3114, 3124, 3125, 3125, 3144, 3147, 3148, 3174, 3197, 3255, 3262, 3288, 3291, 3316, 3320, 3322, 3331, 3342, 3378, 3412, 3412, 3416, 3420, 3427, 3428, 3446, 3452, 3472, 3479, 3483, 3488, 3500, 3516, 3522, 3531, 3532, 3540, 3540, 3544, 3557, 3570, 3580, 3592, 3597, 3597, 3601, 3615, 3631, 3640, 3645, 3673, 3677, 3681, 3683, 3685, 3718, 3738, 3746, 3758, 3769, 3797, 3802, 3815, 3832, 3839, 3851, 3864, 3888, 3889, 3901, 3902, 3910, 3913, 3933, 3940, 3961, 3974, 3988, 4003, 4013, 4019, 4023, 4026, 4047, 4060, 4065, 4072, 4073, 4082, 4084, 4109, 4132, 4139, 4143, 4145, 4146, 4155};
        int i = q.maximizeWin(ints, 6641);
        System.out.println(i);
    }
}
