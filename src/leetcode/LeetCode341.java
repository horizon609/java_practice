/**
 * 
 */

package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月18日
 */
public class LeetCode341 {
    /*
     * Given a nested list of integers, implement an iterator to flatten it.
     * Each element is either an integer, or a list -- whose elements may also
     * be integers or other lists. Example 1: Given the list [[1,1],2,[1,1]], By
     * calling next repeatedly until hasNext returns false, the order of
     * elements returned by next should be: [1,1,2,1,1]. 
     * 
     * Example 2: Given the
     * list [1,[4,[6]]], By calling next repeatedly until hasNext returns false,
     * the order of elements returned by next should be: [1,4,6].
     */
    public class NestedIterator implements Iterator<Integer> {
        /*
         * 思路，这个题考察点有两个：
         * 1. java迭代器:remove，addAll的运用
         * 2. 递归的思想：因为一个list里面有多个符合结构，所以要分别对每个复合结构进行处理。这下分为2种情况：
         * a. 当前位置的一个数字，直接输出
         * b. 当前位置又是一个List<NestedInteger>,进入该子结构循环处理
         * 既然是递归，退出条件就是当前位置的是数字
         * 突破点是NestedInteger接口中的getList()，能不能解出来就看这个条件用的怎么样
         */
        List<NestedInteger> nestedList;
        
        int data;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            return data;
        }

        @Override
        public boolean hasNext() {
            while(nestedList!=null&&nestedList.size()>0){
                NestedInteger subList = nestedList.remove(0);
                if(subList.isInteger()){
                    data = subList.getInteger();
                    return true;
                }else{
                    nestedList.addAll(0, subList.getList());
                }
            }
            return false;
        }
    }

}
