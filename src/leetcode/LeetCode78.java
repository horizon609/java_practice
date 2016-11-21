/**
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月21日
 */
public class LeetCode78 {

    /**
     * Given a set of distinct integers, nums, return all possible subsets.
     * Note: The solution set must not contain duplicate subsets. For example,
     * If nums = [1,2,3], a solution is:
     * [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
        ]
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        System.out.println(subsets(nums));
    }
    /**
     * 这道题的思路和leetcode131基本一致，都是dfs+回溯。这种循环里有递归，递归里又有循环的形式，用于罗列所有可能性。
     * 用一个temp动态数组动态调整当前子数组，罗列出所有的情况 
     */
    public static List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> temp = new ArrayList<Integer>();  
        dfs(res,temp,nums,0);
        return res;
    }

    /**
     * @param res
     * @param temp
     * @param nums
     * @param i
     */
    private static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int i) {
        res.add(new ArrayList<Integer>(temp));
        for(int j = i; j < nums.length;j++){
            temp.add(nums[j]);
            dfs(res,temp,nums,j+1);
            temp.remove(temp.size() - 1);
        }
    }  
}
