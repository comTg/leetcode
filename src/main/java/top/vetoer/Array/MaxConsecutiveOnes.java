package top.vetoer.Array;

import top.vetoer.TimeHelper;

public class MaxConsecutiveOnes {
    // [1,1,0,0,0,1,1,1,1,0,1,1]
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (i == 0)
                sum = 0;
            else
                max = max > sum ? max : sum;
        }
        return max;
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
        int ans = 0;
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length && nums[j] == 1) {
                j++;
            }
            ans = Math.max(ans, j - i);
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            i = j;
        }
        if (i == nums.length - 1)
            ans = Math.max(ans, 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1};
        long start = TimeHelper.start();
        int r = findMaxConsecutiveOnes(nums);
        TimeHelper.runTime(start);
        System.out.println(r);
    }
}
