package com.wjm.everyday;

/**
 * 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class Everyday0916 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int ans1 = 0;
        while (i != destination) {
            ans1 += distance[i];
            i = (i + 1) % distance.length;
        }
        int ans2 = 0;
        i = start;
        while (i != destination ) {
            ans2 += distance[(i + distance.length - 1) % distance.length];
            i = (i + distance.length - 1) % distance.length;
        }

        return Math.min(ans1, ans2);
    }

    public static void main(String[] args) {
        Everyday0916 q = new Everyday0916();
        int[] ints = {1, 2, 3, 4};
        int i = q.distanceBetweenBusStops(ints, 0, 3);
        System.out.println(i);
    }
}
