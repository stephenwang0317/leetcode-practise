package com.wjm.autumn;

import com.wjm.utils.InputConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Question030 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int all = matrix.length * matrix[0].length;
        int cnt = 0;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;

        while (cnt < all) {
            if (t == b) {
                for (int i = l; i <= r; i++) {
                    ans.add(matrix[t][i]);
                    cnt++;
                }
                break;
            }
            for (int i = l; i < r; i++) {
                ans.add(matrix[t][i]);
                cnt++;
            }
            if (l==r){
                for (int i = t; i <= b; i++) {
                    ans.add(matrix[i][r]);
                    cnt++;
                }
                break;
            }
            for (int i = t; i < b; i++) {
                ans.add(matrix[i][r]);
                cnt++;
            }
            for (int i = r; i > l; i--) {
                ans.add(matrix[b][i]);
                cnt++;
            }
            for (int i = b; i > t; i--) {
                ans.add(matrix[i][l]);
                cnt++;
            }
            l++;
            r--;
            t++;
            b--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Question030 q = new Question030();
        int[][] ints = InputConverter.stringToIntArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        System.out.println(q.spiralOrder(ints));
    }
}
