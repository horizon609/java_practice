/**
 * 
 */

package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月13日
 */
public class LeetCode84 {
    /**
     * Given n non-negative integers representing the histogram's bar height
     * where the width of each bar is 1, find the area of largest rectangle in
     * the histogram. For example, Given heights = [2,1,5,6,2,3], return 10.
     */

    /**
     * 思路：分析题意可以直观的看出，选中的那个柱高度，比它左右延伸的柱要低。这时可以把左右这个思想转换成两个数组，每个下标分别记录的是当前柱高往左/右延伸的长度（当前下标所代表的柱高低于左/右下标）
     * 第一步：分别求出左/右下标两个数组 第二部遍历柱高数组
     * 第二部：用其高度乘以宽度（相应下标右＋左-1），选出最大值即可
     * 需要注意的是求左右数组的时候，应该从最边界开始累计计算。
     * 边界条件！！
     * 
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if(heights == null||heights.length == 0) return 0;
        int len = heights.length;
        int[] rightArr = new int[len];
        int[] leftArr = new int[len];
        // 求右数组
        int j = len - 1;// 相当于一个游标，从i到最右端。从右数组最右边开始
        rightArr[j] = 1;// 开始值的是1，最右边的柱的右边已经没有柱，故初始值为1（包含自己）
        for (int i = j - 1; i >= 0; i--) {
            if (heights[i] > heights[i + 1])
                rightArr[i] = 1;
            else {
                j = i + 1;
                while (j < len && heights[j] >= heights[i]) {
                    j += rightArr[j];
                }
                rightArr[i] = j - i;
            }
        }
        int i = 0;// 从左数组最左边开始
        leftArr[i] = 1;
        for (int k = i + 1; k < len; k++) {
            if (heights[k - 1] < heights[k])
                leftArr[k] = 1;
            else {
                i = k - 1;
                while (i >= 0 && heights[i] >= heights[k]) {
                    i -= leftArr[i];
                }
                leftArr[k] = k - i;
            }
        }
        int temp = 0;
        int sum = temp;
        for (i = 0; i < len; i++) {
            temp = heights[i] * ((rightArr[i] + leftArr[i] - 1));
            sum = temp > sum ? temp : sum;
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {
//                2, 1, 5, 6, 2, 3
//        };
        int[] arr = {
                5,8,6,2,3,1,9
        };
        System.out.println(largestRectangleArea(arr));
    }

}
