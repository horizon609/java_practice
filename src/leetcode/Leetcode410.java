/**
 * 
 */
package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月11日
 */
public class Leetcode410 {
    /*
     * Given an array which consists of non-negative integers and an integer m, 
     * you can split the array into m non-empty continuous subarrays. 
     * Write an algorithm to minimize the largest sum among these m subarrays.
     * Input:
     * nums = [7,2,5,10,8]
     * m = 2
     */

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [] arr = {7,2,5,10,8}; 
        Leetcode410 l = new Leetcode410();
        System.out.println(l.splitArray(arr, 2));
    }
    /**
     * 首先来考虑一下边界条件：当m <= 1时 ，返回nums.sum.当m == nums.len时，返回Max(num[0]...num[len - 1])
     * 这个问题表面的做法：先把数组划分为m份，再取子数组的最大值，还要另这个最大值是所有划分方式中的子数组最小值。这样刚正面非常困难= =
     * 需要换一种思路，从边界条件开始考虑，最终求得的值一定是>=数组中的最大值&&<=nums.sum的
     * 这样一来就可以用二分查找的思路,每次调整通过缩小上限||增大下限判断中值mid是否是所求值.
     * 每次都假定mid是正确的返回值，看看能否推出矛盾，即如果把nums分成的份数 > m,如果是这样就说明这个mid太小，需要增加（low = mid+1）（折半查找）
     * 而没有推出矛盾的时候，就减小high值high = mid（折半查找）
     * ps：这个过程完全可以类比折半查找，折半查找的条件很直观，就是比查找值和中值的大小而调整上下限
     * 这个问题更抽象一些，但是本质是一样的。这个条件就是判断分成的份数是否 > m
     * 感觉出这个题的意图就是站在考察折半查找的基础上 强编出来的，不然谁会说“把数组分成m个（包含多种分法）挑出来里面最大数组是所有分法里最小的”2333
     * @param nums 
     * @param m 分成子数组的个数
     * @return 
     */
    public static int splitArray(int[] nums, int m) {
        int len = nums.length;
        int high = 0;
        int low = 0;
        for(int value:nums){
            high += value;
            low = low < value?value:low;
        }
        if(m == len) return low;
        if(m <= 1) return high;
        int mid = low;
        int cur = 0;
        while(low < high){
            mid = (high + low)/2;
            int count = 1;
            cur = 0;
            for(int num:nums){
                cur += num;
                if(cur > mid){
                    count++;
                    cur = num;
                }
            }
            if(count > m){
                low = mid + 1;
            } else{
                high = mid;//新区间有可能包含mid值
            }
        }
        return high;
    }  
}
