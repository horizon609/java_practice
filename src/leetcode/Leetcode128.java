/**
 * 
 */

package leetcode;

import java.util.HashSet;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月9日
 */
public class Leetcode128 {

    /**
     * Longest Consecutive Sequence Given an unsorted array of integers, find
     * the length of the longest consecutive elements sequence. For example,
     * Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence
     * is [1, 2, 3, 4]. Return its length: 4. Your algorithm should run in O(n)
     * complexity.
     */
    public static void main(String[] args) {
        int[] nums = {
                100, 5, 200, 6,7,4, 3, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        // 预处理hash表
        HashSet<Integer> hs = new HashSet<>();
        for (int a : nums) {
            hs.add(a);
        }
        int count = 0;
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            while (hs.contains(temp)) {
                ++count;
                hs.remove(temp);//注意移除hashset中的元素，否则时间复杂度会超过o(n)
                --temp;
            }
            temp = nums[i] + 1;
            while (hs.contains(temp)) {
                ++count;
                hs.remove(temp);
                ++temp;
            }
            max = Math.max(max, count);
            count = 0;
        }
        return max;
    }

}
