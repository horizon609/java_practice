package algorithm;
/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 */
public class BackTypeMatrix {
    public static int LENGTH = 8;
    public static int ROW = 3;
    public static int ROL = 4;
    public static Direction lastDirection = Direction.RIGHT;
    
    public enum Direction{
        RIGHT,DOWN,LEFT,UP
    }
    
    private static Direction getDirection(int row, int col){
        switch(lastDirection){
            case RIGHT:
                if(row == LENGTH - 1 - col){
                    lastDirection = Direction.DOWN;
                }
                break;
            case DOWN:
                if(row == col){
                    lastDirection = Direction.LEFT;
                }
                break;
            case LEFT:
                if(row == LENGTH - 1 - col){
                    lastDirection = Direction.UP;
                }
                break;
            case UP:
                if(row == col + 1){
                    lastDirection = Direction.RIGHT;
                }
                break;
        }
        return lastDirection;
    }
    
    public static int [][] createMatrix(int length){
        int row = 0; 
        int col = 0;
        int value = 1;
        int[][] matrix = new int[length][length];
        for(int i = 0; i < length * length; i++){
            matrix[row][col] = value;
            switch (lastDirection) {
                case RIGHT:
                    col++;
                    break;
                case DOWN:
                    row++;
                    break;
                case LEFT:
                    col--;
                    break;
                case UP:
                    row--;
                default:
                    break;
            }
            value++;
            lastDirection = getDirection(row, col);
        }
        return matrix;
    }
 
    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i<LENGTH;i++){
            for(int j = 0; j < LENGTH; j++){
                System.out.print(matrix[i][j] + "\t");
                if(j == LENGTH - 1){
                    System.out.println();
                }
                
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = createMatrix(LENGTH);
        printMatrix(matrix);
    }

    

}
