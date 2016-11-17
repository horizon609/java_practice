/**
 * 
 */

package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月17日
 */
public class Leetcode45 {
    /**
     * Given an array of non-negative integers, you are initially positioned at
     * the first index of the array. Each element in the array represents your
     * maximum jump length at that position. Your goal is to reach the last
     * index in the minimum number of jumps. For example: Given array A =
     * [2,3,1,1,4] The minimum number of jumps to reach the last index is 2.
     * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     */

    /**
     * 自己的想法：结果不出所料超时，当输入为[1,1,1,1,1.....1,1,1,1,]时，但是你题上又没说需要考虑时间复杂度啊喂！我算是发现了..
     * 以后我提交的答案再也不提交o(n^2)的方案了！ 但是我还是记录一下吧。
     * 1.有一个伪步数表，从倒数第二个位置开始往前，一次跳到最后一个位置所需要的步数
     * 2.hashtable：如果nums相应位置内的值>=上表，则hashtable[index] = true。 //
     * 3.从左到右依次轮训，找到第一个true，然后从该值的前一个index重新处理1中的伪步数表
     * 
     * @param nums
     * @return
     */
    public static int jumpTimeout(int[] nums) {
        int len = nums.length;
        boolean[] hashTable = new boolean[len];
        int pace = 0;
        updateHashTable(nums, hashTable, len - 2);
        for (int i = 0; i < len; i = hashTable[i] == false ? ++i : 0) {
            if (hashTable[i] == true) {
                pace++;
                if (i == 0)
                    break;
                updateHashTable(nums, hashTable, i - 1);
                continue;
            }
        }
        return pace;
    }

    /**
     * @param nums
     * @param hashTable[]
     * @param key
     */
    private static void updateHashTable(int[] nums, boolean[] hashTable, Integer key) {
        int val = 1;
        for (int i = key; i >= 0; i--) {
            if (nums[i] >= val++)
                hashTable[i] = true;
            else
                hashTable[i] = false;
        }
    }

    /**
     * https://discuss.leetcode.com/topic/18815/10-lines-c-16ms-python-bfs-
     * solutions-with-explanations
     * https://discuss.leetcode.com/topic/11408/single-loop-simple-java-solution
     * 这道题的思路其实是BFS，引用链接1的思想: This problem has a nice BFS structure. Let's
     * illustrate it using the example nums = [2, 3, 1, 1, 4] in the problem
     * statement. We are initially at position 0. Then we can move at most
     * nums[0] steps from it. So, after one move, we may reach nums[1] = 3 or
     * nums[2] = 1. So these nodes are reachable in 1 move. From these nodes, we
     * can further move to nums[3] = 1 and nums[4] = 4. Now you can see that the
     * target nums[4] = 4 is reachable in 2 moves. 
     * 假设 [ start, end ] 表示第 i次跳跃才能到达的区间，nextEnd 代表在该区间中起跳的下一个最远元素，那么，[ end+1, nextEnd ] 表示第 i+1
     * 次跳才能去到的范围区间。 
     * 
     * 初始化 [start , end] 为 [0,0]，重复执行上面操作，直到 [start, end]
     * 覆盖到终点元素。由于 [start, end] 表示第 i 次跳跃才能到达的区间，所以 i 便是最小的跳跃次数。
     */
    
    public static int jump(int[] nums) {
        int len = nums.length;
//        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        for(int i = 0; i < len - 1; i++){
            max = Math.max(max, i + nums[i]);
            if(i==end) {
//                start = end + 1;
                end = max;
                count++;
            }
        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {
                6, 4, 7, 1, 2, 3, 1, 1, 4
        };
        System.out.println(jumpTimeout(nums));
        System.out.println(jump(nums));
    }

}
