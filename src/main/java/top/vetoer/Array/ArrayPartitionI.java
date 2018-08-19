package top.vetoer.Array;


import top.vetoer.TimeHelper;

import java.util.Arrays;

/**
 Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
 (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 */

public class ArrayPartitionI {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0;i<nums.length;i+=2){
           result += nums[i];
        }
        return result;
    }

    public static int arrayPairSum2(int[] nums) {
        int[] exist = new int[20001];   // 新建一个20001大小的数组
        for (int i = 0; i < nums.length; i++) {
            exist[nums[i] + 10000]++;       // nums内的数字范围在-1000-1000里面,nums里面相同的数会使 exist[nums[i]+1000] 加上数次
        }
        int sum = 0;        // 最后的结果
        boolean odd = true;     // 是否是奇数, 因为本来效果是排序nums数组,结果是nums数组每个奇数元素的总和,nums[i]+1000以后该是奇数的也是奇数
        for (int i = 0; i < exist.length; i++) {        // 遍历exist数组
            while (exist[i] > 0) {          // 当exist[i] 大于0,表示这里有1或n个nums数组的元素
                if (odd) {  // nums最小的那个数肯定会触发odd
                    sum += i - 10000;   // 第一次加上nums最小的那个数
                }
                odd = !odd; // 如果某个数字不止一次出现,加上一次,跳过一次,做到加上排序后的nums的奇数位元素的效果
                exist[i]--; // exist[i]--,即可做到加上奇数个元素的效果
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        long start = TimeHelper.start();
        int result = arrayPairSum(nums);
        TimeHelper.runTime(start);
        System.out.println(result);
    }



}


