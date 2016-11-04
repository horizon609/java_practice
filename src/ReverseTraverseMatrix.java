import java.util.BitSet;
import java.util.Stack;

/**
 * 
 */

public class ReverseTraverseMatrix {
    public static void main(String args[]){  
        //逆时针输出回形矩阵图  
        int[][] arr = getArray(5,10);  
        for(int i=0;i<arr.length;i++){  
            for(int j=0;j<arr[i].length;j++){  
                System.out.print(arr[i][j]+",");  
            }  
            System.out.println();  
        }  
    }  
    /** 
     * 获取xInt * yInt逆时针回形矩阵数组 
     * @param xInt,矩阵x轴大小 
     * @param yInt,矩阵y轴大小 
     * @return 
     */  
    public static int[][] getArray(int xInt, int yInt){  
        int xMax = xInt;  
        int yMax = yInt;  
        int n = 4;  
        int arr[][]=new int[yMax][xMax];  
        int x = 0, y = 0;  
        int xMin = 0, yMin = 0;  
        int size = xMax * yMax;  
        boolean flag = true;  
        for(int i=0;i<size;i++){  
            arr[y][x] = i+1;  
            if((y+1)<yMax && flag){  
                y++;  
            }else if((x+1)<xMax && flag){  
                x++;  
            }else {  
                if(y>yMin){  
                    y--;  
                }else if(x>(xMin+1)){  
                    x--;  
                }else{  
                    xMax--;  
                    yMax--;  
                    xMin++;  
                    yMin++;  
                    y++;  
                    flag = true;  
                }  
            }  
            if((y+1) == yMax && (x+1) == xMax){  
                flag = false;  
            }  
        }  
        return arr;  
    }  

}
