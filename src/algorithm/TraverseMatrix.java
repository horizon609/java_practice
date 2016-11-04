/**
 * 
 */
package algorithm;

import algorithm.BackTypeMatrix.Direction;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月1日
 */
public class TraverseMatrix {
    public static Direction lastDirection = Direction.RIGHT;
    public static int ROW = 10;
    public static int COL = 5;
    
    public static int[][] matrix;

    public static int[][] createMatrix(int row, int col){
        int[][] matrix = new int[row][col];
        int value = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = value++;
                System.out.print(matrix[i][j] + "\t");
                if(j == col - 1){
                    System.out.println();
                }
            }
        }
        return matrix;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        matrix = createMatrix(ROW, COL);
        traverseMatrix();
    }

    private static void traverseMatrix() {
        int xMax = ROW;
        int yMax = COL;
        int xMin = 0;
        int yMin = 0;
        int x = 0;
        int y = 0;
        boolean flag = true;//控制旋转方向：true为x||y增长而false为x||y减小
        for(int i = 0; i < ROW * COL; i++){
            System.out.print(matrix[x][y] + " ");
            if(y < yMax - 1 && flag){
                y++;
            } else if (x < xMax - 1 && flag){
                x++;
            } else { //减小方向
                if(y > yMin){
                    y--;
                }else if(x > xMin + 1){
                    x--;
                }else{
                    y++;
                    xMax--;
                    yMax--;
                    xMin++;
                    yMin++;
                    flag = true;
                }
            }
            if(x == xMax-1 && y == yMax-1){
                flag = false;
            }
        }
    }

}
