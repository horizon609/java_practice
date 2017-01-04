/**
 * 
 */
package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2017年1月4日
 * 
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.

 * Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Leetcode287 {
    /**
     * n=5时，1<nums包含的数字<=5
     * index{0,1,2,3,4,5}
     * nums={3,1,2,4,2,5}
     * 将nums中的数字组成链表，从下标==5开始选取，nums[5]==5,那么第一次就进入了5->5的死循环中。但是第一位只要不是5是其他任何一位都可以循环起来，又由题可知，最小的位数是1，
     * 那么完全可以给nums的每一位都-1，这样可以保证nums[5] <=4,从而能循环起来。
     * 解题思路
     * 1.将重复的数字放入循环当中
     * 2.在环中找到重复的那一位
     * 该问题涉及较多链表操作和判断，可以参考http://www.cnblogs.com/smyhvae/p/4782595.html复习链表的知识
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++) nums[i]--;
        int slow = n-1;
        int fast = n-1;
        do{//慢指针每次前进一步，快指针每次前进两步
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);//实现了第一步，找到了带有重复数字的环。但是相等的那一个数字可能是环里的任何一位，不一定就是重复的那个数字
        slow = n-1;
        while(slow != fast){//然后快慢指针都是每次前进一步，重合时找到的就是重复数字（环的头结点），前面的slow = nums[slow];fast = nums[nums[fast]];决定了，相遇点就在环的倒数第二个结点处。
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow+1;//恢复出厂
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
