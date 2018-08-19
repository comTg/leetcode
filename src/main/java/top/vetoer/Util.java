package top.vetoer;

import java.util.Arrays;

public class Util {
    public static void printMatrix(int[][] A){
        System.out.print("[");
        for(int[] row:A){
            System.out.print(Arrays.toString(row)+",");
        }
        System.out.println("]");
    }

    public static void printArray(String[] arr){
        for(String s:arr){
            System.out.print(s+",");
        }
    }
}
