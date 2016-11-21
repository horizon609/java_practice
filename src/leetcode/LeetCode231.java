/**
 * 
 */

package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月19日
 */
public class LeetCode231 {
    /*
     * Given an integer, write a function to determine if it is a power of two.
     */
    /* 看起来简单的题需要考虑的不仅是最优解，更有边界条件
     * 我的解体思路：最容易想到的是循环，判断一个数是不是2的幂，从2开始累乘，乘到最后大于该数就不是，等于就是，这种情况对于n的增大时间复杂度增大。时间复杂度肯定过不了。放弃
     * 第二个思路hash表，因为这种数的特征转换成2进制就是首位是1，其他位是0，所以预处理一个hash表，把这种情况记录下来，时间复杂度为1.由于int4字节，转换为二进制32位，空间复杂度上接受不了，放弃
     * 进而利用第二个思路，逆过来想，从低位开始判断，如果除了首位，其他位出现1就可以立即淘滩，这个时间复杂度和空间复杂度肯定都满足要求
     * 但是上述只是除了了从2^1,2^..还需要考虑2^0和n < 0的情况。
     */
    public boolean isPowerOfTwo(int n) {
        if(n > 0){
            if(n == 1) return true;
            while(n%2==0){
                n /= 2;
                if(n == 1) return true;
            }
            return false;
        }else return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
