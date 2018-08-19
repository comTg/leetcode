package top.vetoer.Array;

import top.vetoer.TimeHelper;
import top.vetoer.Util;

import java.util.Arrays;

/**
 * Given a matrix A, return the transpose of A.

 The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 */

public class TransposeMatrix {
    public static int[][] transpose(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        int[][] result = new int[y][x];
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[][] t = {{1,2,3},{2,4,5},{2,5,7}};
        long start = TimeHelper.start();
        int[][] r = transpose(t);
        TimeHelper.runTime(start);
        Util.printMatrix(r);
    }
}
