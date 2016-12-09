/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 81303
Total Submissions: 333939
Difficulty: Medium
Contributors: Admin
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月9日
 */

public class LeetCode54 {
    /**
     * 这个问题最重要的部分在于定于动态变化的四个参数，即行、列的变化范围。当这四个参数能被正确定义出来，问题本身并不难解决。
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;//注意二维数组的length就是其行数
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;//将matrix二维数组转化成一位数组
        while(rowBegin <= rowEnd && colBegin <= colEnd){//rowBegin和rowEnd代表向上或向下的时遍历的范围，colBegin和colEnd同理。
            //所以能进到这里来的代码的最小情况是是上面四个参数都相同的一个点，也就是n阶矩阵的中点。其他时候要么是一条横/竖线，要么是一个小于n阶的矩阵
            //处理向右情况
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //处理向下情况
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            //处理向左情况
            if (rowBegin <= rowEnd) {// 若不判断会出错[[2,3]]->[2,3,2]
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            //处理向上情况
            if (colBegin <= colEnd) { // 若不判断，可根据上一条[[2],[3]]->[2,3,3]
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

}
