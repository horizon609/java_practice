/**
 * 
 */

package leetcode;

import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月10日
 */
public class LeetCode219 {

    /**
     * Given an array of integers and an integer k, find out whether there are
     * two distinct indices i and j in the array such that nums[i] = nums[j] and
     * the difference between i and j is at most k.
     */
    /**
     * 这个问题注意问题：1.边界条件：例如输入[99,99]2时，应返回true
     * 边界条件：2.[1,2,3,4,5,6,7,8,9,9]3
     * 3.超时了竟然！！然后重新思考，用hashMap来记录下标和值,将num[i]作为K，而i作为V，比较相同K对应的V，若小于等于k则返回true
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        int i,j;
        if(k >= len) k = len - 1;//验证边界条件
        for (i = 0, j = k; i < len - k; i++,j = i+k) {
            while (j > i) {
                if (nums[i] == nums[j--])
                    return true;
            }
        }
        //加上i>=len-k时的边界条件
        for(j = len - 1; i < len - 1; i++,j = len - 1){
            while(j > i){
                if(nums[i] == nums[j]) return true;
                j--;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateOpt(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i < nums.length; i++){
            Integer dupVal = hm.get(nums[i]);
            if(dupVal != null){
                if(i - dupVal <= k) return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
    
    public static void main(String[] args) {
//        int [] arr = {10,2,3,4,9,6,7,8,9,10};
        int [] arr = {1,2,3,4,5,4};
        System.out.println(containsNearbyDuplicateOpt(arr, 20));
    }
}
