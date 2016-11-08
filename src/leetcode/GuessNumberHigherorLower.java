/**
 * 
 */
package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月8日
 */
public class GuessNumberHigherorLower extends GuessGame{

//    private static int n = 0;
    private static GuessGame gg;

    //递归
    public static int guessNumber(int n){
        return recursion(0, n);
    }
    
    public GuessNumberHigherorLower(int n){
        super(n);
    }
    
    
    private static int recursion(int start, int end) {
        int mid = (start + end) / 2;
        if(gg.guess(mid)>0){
            return recursion(mid+1,end);
        }else if(gg.guess(mid) < 0){
            return recursion(start, mid - 1);
        }else {
            return mid;
        }
    }
    
    public static void main(String[] args) {
        int n = 100;
        gg = GuessGame.getInstance(100);
        System.out.println(guessNumber(n));
        System.out.println("right num: " + gg.getRightNum());
    }

}
