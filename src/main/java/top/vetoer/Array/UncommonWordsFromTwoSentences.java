package top.vetoer.Array;

import top.vetoer.TimeHelper;
import top.vetoer.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public static String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> count = new HashMap<>();
        for(String s: (A+ " "+B).split(" ")){
            count.put(s,count.getOrDefault(s,0)+1);
        }
        ArrayList<String> r = new ArrayList<>();
        for(String s:count.keySet()){
            if(count.get(s)==1)
                r.add(s);
        }
        return r.toArray(new String[r.size()]);
    }
    public static void main(String[] args){
        String A = "this apple is sweet", B = "this apple is sour";
        long start = TimeHelper.start();
        String[] r = uncommonFromSentences(A,B);
        TimeHelper.runTime(start);
        Util.printArray(r);
    }
}
