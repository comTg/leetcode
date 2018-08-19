package top.vetoer.Array;

import top.vetoer.TimeHelper;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start < 0) {
                    start = i;
                }
            } else {
                end = i;
                if (start >= 0) {
                    swap(nums, start, end);
                    start++;
                }
            }
        }
    }

    // nice solution
    public void moveZeroes2(int[] nums) {
        if (nums == null)
            return;
        int len = nums.length;
        if (len == 0)
            return;
        int z = 0, flag = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                while (z < len && nums[z] != 0) {
                    z++;
                }
                if (z < i) {
                    nums[z] = nums[i];
                    nums[i] = 0;
                }

            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
//        int[] nums = {1,2,0,0,4,5,6,0,2,0,4};
        int[] nums = {0, 1, 0, 3, 12};
        long start = TimeHelper.start();
//        m.moveZeroes(nums);
        m.moveZeroes2(nums);
        TimeHelper.runTime(start);
        System.out.println(Arrays.toString(nums));
    }
}
