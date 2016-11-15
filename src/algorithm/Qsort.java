/**
 * 
 */
package algorithm;

import java.util.Arrays;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月12日
 */
public class Qsort {
//    static int []a = {4,2,7,6,9,8,1,5};
    
    static int []a = {0,1,2,3,4,5,6,7};
    public static void main(String[] args) {
        QSort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }
    
    private static void QSort(int[]a,int low,int high){
        if(low<high){
            int left = partition(a, low, high);
            QSort(a, low, left-1);
            QSort(a, left+1, high);
            
        }
        
    }
    private static int partition(int []a,int low,int high){
        int p = a[high];
        int left = low;
        int right = high - 1;
        while(left < right){
            while(a[right]>p && left < right){
                right--;
            }
            while(a[left] <p&&left<right){
                left++;
            }
            if(left < right) swap(left,right);
        }
        //判断放置pivok的正确地方：到这里的时候left==right，那么要做的就是将left和pivok做一个比较，如果a[left] < pivok
        //那么left++，因为一趟排序的最终目的是，找到pivok的正确放置位置，该位置左边的所有数<=它，右边的数>=它
        if(a[left] < p) left++;
        swap(left,high);
        return left;
    }

    /**
     * @param left
     * @param right
     */
    private static void swap(int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    

}
