/**
 * 
 */

package algorithm;

import java.util.Arrays;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月21日
 */
public class ZigZag {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));// PAHNAPLSIIGYIR
    }

    public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0)
            return "";
        if (nRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            int temp = size - 2*i;
            for(int j = i; j < s.length(); j+=size){
                res.append(s.charAt(j));
                if(i !=0 &&i!=nRows-1){
                    if((j+temp) <s.length()){
                        res.append(s.charAt(j+temp));
                    }
                }
            }

        }
        return res.toString();
    }
}
