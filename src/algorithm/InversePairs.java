/**
 * 
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月3日
 */
public class InversePairs {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int array[] = {1,3,7,8,2,4,6,5};
        System.out.println(getInversePairs(array, 0, array.length-1));
    }

    /**
     * 思路：对于求解递归类问题：最重要需要确定的是退出条件，在这里确定最小队列长度就显得很重要，4个元素的数组最合适思考，最好能画出递归树帮助思考
     * @param array
     */
    private static int getInversePairs(int[] array, int start, int end) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int mid = (end+start)/2;
        int count = 0;
        if(start >= end) return 0;
        count += getInversePairs(array, start, mid);
        count += getInversePairs(array, mid+1, end);
        count += mergeArray(array,start,mid,end);
        return count;
    }

    /**
     * @param array
     * @param start
     * @param mid
     * @param end
     * @return
     */
    private static int mergeArray(int[] array, int start, int mid, int end) {
        int count = 0;
        int [] list = new int[end - start + 1];
        int indexA = mid;
        int indexB = end;
        int index = 0;
        while(indexA >= start && indexB > mid){
            if(array[indexA] > array[indexB]){
                count += indexB - mid;
                list[index++] = array[indexA--];
            } else{
                list[index++] = array[indexB--];
            }
        }
        while(indexA >= start){
            list[index++] = array[indexA--];
        }
        while(indexB > mid){
            list[index++] = array[indexB--];
        }
        for(int i = 0; i < index; i++){
            array[end--] = list[i];
        }
        return count;
    }

}
