package top.vetoer.HashTable;

import top.vetoer.TimeHelper;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        Map<Character,Integer> result = new Hashtable<>();
        for(int i = 0;i < J.length();i++){
            result.put(J.charAt(i),0);
        }
        int count = 0;
        for(int i = 0;i<S.length();i++){
            if(result.containsKey(S.charAt(i)))
                count++;
        }
        return count;
    }
    public static int numJewelsInStones2(String J, String S) {
//        char[] arr1 = J.toCharArray();
//        char[] arr2 = S.toCharArray();
//        int count = 0;
//        for(int i = 0;i<arr1.length;i++){
//            for(int j = 0;j<arr2.length;j++){
//                if(arr2[j]==arr1[i])
//                    count++;
//            }
//        }
//        return count;
        int cntJewels = 0;
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return cntJewels;
        }
        int[] hash = new int[256];
        for (char ch : S.toCharArray()) {
            hash[ch]++;
        }
        for (char ch : J.toCharArray()) {
            if (hash[ch] != 0) {
                cntJewels += hash[ch];
                hash[ch] = 0;
            }
        }
        return cntJewels;
    }

    public static void main(String[] args){
        String J = "az";
        String S = "sfgighhaaaZfsfz";
        long start = TimeHelper.start();
        int c = numJewelsInStones2(J,S);
        TimeHelper.runTime(start);
        System.out.println(c);
    }
}
