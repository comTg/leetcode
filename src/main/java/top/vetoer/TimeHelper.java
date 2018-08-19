package top.vetoer;

public class TimeHelper {
    public static long start(){
        return System.nanoTime();
    }
    public static void runTime(long start){
        long end = System.nanoTime();
        long run = end - start;
        System.out.println("运行时间是: " + String.valueOf(run));
    }
}
