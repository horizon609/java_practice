/**
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月22日
 */
public class Leetcode77 {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
     */
    /**
     * 最近已经碰到好几个这种dfs+回溯的套路了，只要理解了原理，这一类的问题就迎刃而解了。
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(n,k,res,temp,1);
        return res;
    }

    /**
     * @param n
     * @param k
     * @param res
     * @param temp
     * @param i 
     */
    private static void dfs(int n, int k, List<List<Integer>> res, List<Integer> temp, int i) {
        if(temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
        }else{
            for(int j = i;j<=n;j++){
                if(k!=temp.size()){
                    temp.add(j);
                    dfs(n, k, res, temp, j+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

}
