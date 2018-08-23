package top.vetoer.Array;

import top.vetoer.TimeHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!res.containsKey(nums[i])) {
                res.put(nums[i], 1);
            } else {
                res.replace(nums[i], res.get(nums[i]) + 1);
            }
        }
        for (int key : res.keySet()) {
            if (res.get(key) > n / 2)
                return key;
        }
        return 0;
    }

    // nice solution
    public int majorityElement2(int[] nums) {
        int can = nums[0],count = 1;
        for(int i = 0;i<nums.length;i++){
            if(can == nums[i]){
                count++;
            }else{
                count--;
                if(count==0){
                    can = nums[i];
                    count = 1;
                }
            }
        }
        if(count>0) return can;
        return 0;
    }

    public static void main(String[] args) {
        int[] t = {3, 2, 3};
        MajorityElement me = new MajorityElement();
        long start = TimeHelper.start();
        System.out.println(me.majorityElement(t));
        TimeHelper.runTime(start);
        start = TimeHelper.start();
        System.out.println(me.majorityElement2(t));
        TimeHelper.runTime(start);
    }
}
