package top.vetoer.Array;

import top.vetoer.TimeHelper;
import top.vetoer.Util;

import java.util.LinkedList;
import java.util.Queue;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c)
            return nums;
        Queue<Integer> queue = new LinkedList<>();
        for(int[] t:nums){
            for(int i = 0;i<t.length;i++){
                queue.add(t[i]);
            }
        }
        int[][] result = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                result[i][j] = queue.remove();
            }
        }
        return result;
    }

    public static int[][] matrixReshape2(int[][] nums,int r,int c){
        if(nums.length == 0 || r*c != nums.length*nums[0].length)
            return nums;
        int row = 0,col = 0;
        int[][] result = new int[r][c];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums[i].length;j++){
               result[row][col++] = nums[i][j];
               if(col==c){
                   col = 0;
                   row++;
               }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,4},{2,4,5}};
        long start = TimeHelper.start();
        int[][] result = matrixReshape2(nums,6,1);
        TimeHelper.runTime(start);
        Util.printMatrix(result);
    }
}
