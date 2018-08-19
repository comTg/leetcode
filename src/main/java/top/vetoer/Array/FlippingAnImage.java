package top.vetoer.Array;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - 1 - i]) {
                    row[i] = row[n - 1 - i] ^= 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] t = {{1, 0, 0}, {1, 1, 0}, {1, 0, 1}};
        long start = start();
        int[][] A = flipAndInvertImage(t);
        printRunTime(start);
        for (int[] row : A) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static long start() {
        return System.nanoTime();
    }

    public static void printRunTime(long start) {
        long end = System.nanoTime();
        long run = end - start;
        System.out.print("运行时间: ");
        System.out.println(run);
    }
}

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 */



//class Solution1 extends Solution {
//    public int[][] flipAndInvertImage(int[][] A) {
//        if (A == null || A.length == 0) {
//            return null;
//        }
//        int length = A.length;
//        for (int[] row : A) {
//            for (int i = 0; i < (length + 1) / 2; i++) {
//                int temp = row[i] ^ 1;
//                row[i] = row[length - 1 - i] ^ 1;
//                row[length - 1 - i] = temp;
//            }
//        }
//        return A;
//    }
//}


//class Solution3 extends Solution {
//    public int[][] flipAndInvertImage(int[][] A) {
//        int n = A.length;
////        for(int j = 0; j < n / 2 + n % 2; j++){
//        for (int j = 0; j * 2 < n; j++) {
//            for (int i = 0; i < n; i++) {
//                int tmp = A[i][j];
//                A[i][j] = A[i][n - 1 - j] ^ 1;
//                A[i][n - 1 - j] = tmp ^ 1;
//            }
//        }
//        return A;
//    }
//}

//class Solution4 extends Solution {
//    public int[][] flipAndInvertImage(int[][] A) {
//        for (int i = 0; i < A.length; i++) {
//            int lo = 0, hi = A[0].length - 1;
//            while (lo <= hi) {
//                if (A[i][lo] == A[i][hi]) {
//                    A[i][lo] = 1 - A[i][lo];
//                    A[i][hi] = A[i][lo];
//                }
//                lo++;
//                hi--;
//            }
//        }
//
//        return A;
//    }
//}