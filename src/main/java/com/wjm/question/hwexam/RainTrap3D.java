package com.wjm.question.hwexam;

import com.wjm.utils.InputConverter;

public class RainTrap3D {
    public int trapRainWater(int[][] heightMap) {
        int N = heightMap.length;
        int M = heightMap[0].length;
        int[][] left = new int[N][M];
        int[][] right = new int[N][M];
        int[][] forward = new int[N][M];
        int[][] back = new int[N][M];
        for (int i = 0; i < M; i++) {
            left[0][i] = heightMap[0][i];
        }
        for (int i = 0; i < M; i++) {
            right[N - 1][i] = heightMap[N - 1][i];
        }
        for (int i = 0; i < N; i++) {
            forward[i][0] = heightMap[i][0];
        }
        for (int i = 0; i < N; i++) {
            back[i][M - 1] = heightMap[i][M - 1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                left[i][j] = Math.max(left[i - 1][j], heightMap[i][j]);
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                right[i][j] = Math.max(right[i + 1][j], heightMap[i][j]);
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                forward[j][i] = Math.max(forward[j][i - 1], heightMap[j][i]);
            }
        }
        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                back[j][i] = Math.max(back[j][i + 1], heightMap[j][i]);
            }
        }


        int ans = 0;
        int[][] gap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                gap[i][j] = Math.min(Math.min(left[i][j], right[i][j]), Math.min(forward[i][j], back[i][j]));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans += (gap[i][j] - heightMap[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RainTrap3D t = new RainTrap3D();
        int[][] ints = InputConverter.stringToIntArray("[[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]");
        System.out.println(t.trapRainWater(ints));
    }
}
