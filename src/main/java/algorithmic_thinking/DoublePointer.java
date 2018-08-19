package algorithmic_thinking;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 双指针: 双指针主要用来遍历数组,两个指针指向不同的元素,从而协同完成任务
 */
public class DoublePointer {
    // leetcode:167   从有序数组中找出两个数,使他们的和为target
    public int[] twoSum(int[] numbers,int target){
        int i  = 0,j = numbers.length-1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }else if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }
        }
        return null;
    }

    // leetcode:633   判断一个数是否为两个数的平方和,例如 5=1^2 + 2^2
    public boolean judgeSquareSum(int c){
        int i = 0,j = (int)Math.sqrt(c);
        while(i <= j){
            int powSum = i*i + j*j;
            if(powSum == c)
                return true;
            else if(powSum>c)
                j--;
            else
                j++;
        }
        return false;
    }

    // leetcode:345   反转字符串中的元音字符, Given s = "leetcode" ,return "leotcede;
    public String reverseVowels(String s){
       HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','0','u','A','E','I','O','U'));
       int i = 0,j = s.length()-1;
       return null;

    }


























}
