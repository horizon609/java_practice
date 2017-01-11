/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

    For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2017年1月10日
 */
public class LeetCode279 {
    /**
     * 一开始的思路是通过递归，例如12开根号为3->从1,4,9中诞生。9入栈，4入栈，和超过12，则4出栈。1入栈1入栈->9,1,1,1,1=>5.但是我忽略了要求最小值最小值是4+4+4->3
     * 故这种思路错误
     * 应该选用动态规划策略
     * n=0 dp[0] = 0
     * n=1 dp[1] = 1(1)
     * n=2 dp[2] = 2(1+1)
     * n=3 dp[3] = 3(1+1+1)
     * n=4 dp[4] = min(dp[4-1*1]+1(选择了一个1)，dp[4-2*2]+1(选择了一个4))=min(dp[3]+1,dp[0] + 1)=1
     * ...
     * n=n dp[n] = min(dp[n-1*1]+1,dp[n-2*2]+1,dp[n-3*3]+1,...,dp[n-i*i]+1)其中n-i*i>=0
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        int i = 1;
        int min = Integer.MAX_VALUE;
        for(int j = 1;j<=n;j++){
            while(j-i*i>=0){
                min = Math.min(min, dp[j-i*i]+1);
                i++;
            }
            dp[j] = min;
            min = Integer.MAX_VALUE;
            i = 1;
        }
        return dp[n];
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}
