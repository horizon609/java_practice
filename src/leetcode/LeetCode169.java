/**
 * 
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.parser.Entity;


/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月20日
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class LeetCode169 {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.get(i)==null){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2,1,2,1,2,1}));
    }

}