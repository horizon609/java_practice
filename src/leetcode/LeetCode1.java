/**
 * 
 */

package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 一开始的想法：1.构建一个HashMap,把nums里的值作为KEY，把下标作为VALUE。
 * 2.将nums排序为array
 * 3.low和high分别指向array的首和尾
 * 4.找到low和high值
 * 5.在hashMap中查找nums[low]、nums[high]的值
 * 然后跪在在测试用例：[0,4,3,0] 0 正确返回：[0,3] 真实返回：[3,3].因为忽略了hashmap里不能有重复键这一点。
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月13日
 */
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length;i++){
            if(hashMap.containsKey(target - nums[i])){
                res[0] = hashMap.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            hashMap.put(nums[i], i);
        }
        return res;
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {
                3,2,4
        };
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

}
