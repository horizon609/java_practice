/**
 * 
 */
package leetcode;

import java.util.Random;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月8日
 */
public class GuessGame {
    private int rightNum;
    public  int getRightNum() {
        return rightNum;
    }
    private static GuessGame gg = null;
    public static GuessGame getInstance(int n){
        if (gg == null){
            gg = new GuessGame(n);
        }else{
            return gg;
        }
        return gg;
    }

    /**
     * 
     */
    private int n;
    protected GuessGame(int n) {
        this.n = n;
        rightNum = (int) (n * Math.random());
    }
    public int guess(int num){
        if(num < rightNum){
            return 1;
        }else if( num > rightNum){
            return -1;
        }else{
            return 0;
        }
    }
}
