package com.wjm.question.codetop;
/*
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * */

import com.wjm.utils.InputConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                l.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                l.add(matrix[i][right]);
            }

            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    l.add(matrix[bottom][i]);
                }
            }
            if (left < right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    l.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] ints = InputConverter.stringToIntArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        Question054 q = new Question054();
        System.out.println(q.spiralOrder(ints));
    }
}
