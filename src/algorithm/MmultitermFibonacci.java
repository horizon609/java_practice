/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月2日
 */
public class MmultitermFibonacci {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(Kfibonacci(7,3));
    }
    
    /**
     * n从下标为0开始
     * fibonacci(n) = 1
     * 当n <= 1
     * fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2) 当n > 1时
     * 非递归方式实现！
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        if(n <= 1) return 1;
        int first = 1;
        int second = 1;
        int cur = 0;
        for(int i = 2; i <= n; i++){
            cur = first + second;
            first = second;
            second = cur;
        }
        return cur;
        
    }
    
    /**
     * k项斐波那契展开式
     * n从下标为0开始
     * Kfibonacci(n) = fibonacci(n) 当n < k时
     * Kfibonacci(n) = Kfibonacci(n - k) + Kfibonacci(n - k + 1) + ... + Kfibonacci(n - 1)当n >= k时
     * 非递归方式实现！
     */
    public static int Kfibonacci(int n,int k){
        //选用一个数组来存放所需要的变量
        if(n < k) return fibonacci(n);
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = fibonacci(i);
        }
        for(int j = 0;j < n - k - 1; j++){//更新次数
            updateArray(arr);
        }
        int sum = 0;
        for(int i = 0; i < k;i++){
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 变换arr:{1,1,2,3,5} -> {1,2,3,5,8}
     * @param arr
     */
    private static int[] updateArray(int[] arr) {
        if(arr.length < 3)return null;
        int sum = 0;
        for(int i = 0; i < arr.length - 1; i++){
            sum += arr[i];
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = sum + arr[arr.length - 1];
        return arr;
    }
    

}
