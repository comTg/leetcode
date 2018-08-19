package top.vetoer;

import java.util.Arrays;

public class Test {
    public int TestArray(int[] arr){
        for(int i = 0;i<arr.length;i++){
            arr[i] = i*i;
        }
        return arr[arr.length-1];
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        Test t = new Test();
        System.out.println(t.TestArray(arr));
        System.out.println(Arrays.toString(arr));
    }
}
