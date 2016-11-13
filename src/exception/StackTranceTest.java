/**
 * 
 */
package exception;

import java.util.Scanner;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月13日
 */
public class StackTranceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        factorial(n);
    }
    
    private static int factorial(int n){
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] ste = t.getStackTrace();
        for(StackTraceElement s:ste){
            System.out.println(s.toString());
        }
        int r = 0;
        if(n <= 1) r = 1;
        else r = n * factorial(n-1);//这个else加上和去掉完全不同
        System.out.println("return:" + r);
        return r;
    }

}
