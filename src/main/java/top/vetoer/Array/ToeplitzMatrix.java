package top.vetoer.Array;

import top.vetoer.TimeHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */

public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix1(int[][] matrix) {
        Map<Integer, Integer> group = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!group.containsKey(r - c))
                    group.put(r - c, matrix[r][c]);
                else if (group.get(r - c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    // It's nice solution
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 0,0 1,1, 2,2 ,3,3 same //  0,1  1,2  1,3  -1  same  //
    public static void main(String[] args) {
        int[][] t = {{1, 2, 3, 4},
                {3, 1, 2, 3},
                {4, 3, 1, 2}};
        long start = TimeHelper.start();
        boolean r = isToeplitzMatrix(t);
        TimeHelper.runTime(start);
        System.out.println(r);
    }
}
