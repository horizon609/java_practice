/**
 * 
 */
package cover_lines;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月21日
 */
public class CoverLine {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] dot = {{5, 8},{10, 45},{0, 7},
                {2, 3},    {5, 9},    {13, 26},
                {15, 38},  {50, 67},    {39, 42},
                {70, 80}
             }; 
        Line[] arr = new Line[10];
        for(int i = 0; i < dot.length; i++){
            Line line = new Line();
            line.start = dot[i][0];
            line.stop = dot[i][1];
            arr[i] = line;
        } 
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(getSumLength(arr));
    }
    
    public static class Line implements Comparable<Line>{
        int start;
        int stop;
       
        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
       
        @Override
        public String toString() {
            return "{"+start+","+stop + "}";
        }
    }

    public static int getSumLength(Line[] arr){
        int length = 0,start,end;
        for(int i = 0; i < arr.length - 1;i++){
            start = arr[i].start;
            end = arr[i].stop;
            while(arr[i+1].start < arr[i].stop){
                end = arr[i].stop > arr[i + 1].stop?arr[i].stop:arr[i + 1].stop;
                i++;
            }
            length += end - start;
        }
        return length;
    }
    
    
    

}
