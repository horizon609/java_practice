/**
 * 
 */
package leetcode;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月9日
 */
/**
 * 前置题目：54..
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月9日
 */
public class LeetCode59 {
    public static int[][] generateMatrix(int n) {
        if(n <= 0) return new int[][]{};//一开始我这写的是{{}}报错了= =||
        if(n == 1) {
            return new int[][]{{1}};
        }
        int [][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd= matrix[0].length-1;
        int count = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                count += 1;
                matrix[rowBegin][j] = count;
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j++) {
                count += 1;
                matrix[j][colEnd] = count;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    count += 1;
                    matrix[rowEnd][j] = count;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    count += 1;
                    matrix[j][colBegin] = count;
                }
            }
            colBegin++;
            
        }
        return matrix;
        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] matrix = new int[5][5];
        matrix = generateMatrix(10);
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

}
