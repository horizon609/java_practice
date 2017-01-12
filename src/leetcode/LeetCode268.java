/**
 * 
 */

package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array. For example, Given nums = [0, 1, 3]
 * return 2. Note: Your algorithm should run in linear runtime complexity. Could
 * you implement it using only constant extra space complexity?
 * 
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2017年1月11日
 */
public class LeetCode268 {
    /**
     * 利用异或的性质：
     * 1.交换律
     * 2.0^a = a
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int xor = 0;
        int i = 0;
        for(; i < len; i++){
            xor = xor ^ i ^ nums[i];
        }
        return xor^i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2,4,5}));
        System.out.println(missingNumber(new int[]{0,1,3,4,5}));
        System.out.println(missingNumber(new int[]{0,1,2,4,}));
        System.out.println(missingNumber(new int[]{0,1,3,4}));
        System.out.println(missingNumber(new int[]{0,2,3,4,5,6}));
        System.out.println(missingNumber(new int[]{1,2,3,4,5}));
        System.out.println(missingNumber(new int[]{0}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{0,3,2}));
    }

}
