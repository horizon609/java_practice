/**
 * 
 */

package leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月16日
 */
public class LeetCode172 {
    /**
     * 题目的意思是说，求出n！末尾有几个0，限定用时：对数时间 这个题一般人都知道求解阶乘不然就是递归或循环乘，时间复杂度超标
     * 所以需要直接分析什么阶乘后面会产生0，所以我先写了个代码看了一下（注释掉的那些）
     * 观察可知（观的眼都要瞎了）10！11！12！后面都是2个0，想想末尾产生0的原因：有一对质因子2和5产生1个0
     * 那么现在的问题就变成了找到n！中(2
     * ，5）质因子有几对,观察10！（2^8*3^4*5^2*7^1）/11!(2^8*3^4*5^2*7^1*11)
     * /12(2^10*3^5*5^2*7^1) 把n！全部分解成质因数相乘的形式，可以观察出来2的个数总是>=5的个数
     * 现在问题转化成了求质因数5的个数。 到这一步我,我当前的能力就分析不下去了，查了资料，有一个公式刚好可以解决这个问题即floor(n/5)
     * 注意floor是简单求法，需要注意的问题是当n==25||n==125||以此类推的情况,例如当n==26时
     * 26的阶乘：26*25*24*23*22
     * *21*20*19*18*17*16*15*14*13*12*11*10*9*8*7*6*5*4*3*2*1 ->(5^6...)，f(26) =
     * floor(5) + floor(25) 那么可以推到算法公式：n！末尾的0的个数 = f(n) = floor(n/5) +
     * floor(n/25) + floor(n/125) + ... 推到这一步就可以开始动手写代码了 ... 写完了发现代码只有6行。
     * 考验数学的推倒功底，注意加强
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        // for(int i = 1; i <=30;i++){//溢出
        // factorial(i);
        // System.out.println();
        // }
        System.out.println(trailingZeroes(625));
    }

    private static int trailingZeroes(int n) {
         int res = 0;
         while (n > 1) {
         res += n / 5;
         n /= 5;
         }
         return res;
    }

    private static BigInteger factorial(int n) {
        System.out.print(n + "的阶乘：");
        for (int i = n; i > 1; i--) {
            System.out.print(i + "*");
        }
        System.out.print("1");
        // 求阶乘
        BigInteger res = new BigInteger("1");
        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                res = res.multiply(new BigInteger(i + ""));
            }
        }
        System.out.print("=" + res);
        return res;
    }

}
