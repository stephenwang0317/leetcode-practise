package com.wjm.utils;

/**
 * @author stephen wang
 */
public class InputConverter {

    public static char[][] stringToCharArray(String input) {
        // 去除字符串中的空格和换行符
        input = input.replaceAll("\\s", "");

        // 去除字符串中的外层方括号
        input = input.substring(2, input.length() - 2);

        // 分割字符串为行
        String[] rows = input.split("\\],\\[");

        char[][] result = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            // 分割每一行为字符数组
            String[] cells = rows[i].split(",");
            result[i] = new char[cells.length];

            // 去除双引号并转换为字符
            for (int j = 0; j < cells.length; j++) {
                result[i][j] = cells[j].charAt(1);
            }
        }
        return result;
    }

    public static int[][] stringToIntArray(String input) {
        String[] rows = input.substring(2, input.length() - 2).split("\\],\\[");

        // 创建二维数组
        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        int[][] resultArray = new int[numRows][numCols];

        // 填充数组
        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                resultArray[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return resultArray;
    }

}
