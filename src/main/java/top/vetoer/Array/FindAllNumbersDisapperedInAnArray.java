package top.vetoer.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */

public class FindAllNumbersDisapperedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                r.add(i + 1);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FindAllNumbersDisapperedInAnArray fad = new FindAllNumbersDisapperedInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = fad.findDisappearedNumbers(nums);
        System.out.println(res.toString());


    }
}
