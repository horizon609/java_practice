package algorithm;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月25日
 */
public class SumOfKNumber {
    static int length;

    /**
     * @param args
     */
    public static void main(String[] args) {
//        int n,m;
//        Scanner s=new Scanner(System.in);
//        n=s.nextInt();
//        m=s.nextInt();
        length=6;
        int[] flag=new int[6];
        findCombination(6, 5, flag);
    }
    
    static void findCombination(int n,int sum,int flagI[]){
        if (n<1||sum<1) {
            return;
        }
        if (n>sum) {
            n=sum;
        }
        if (n==sum) {
            flagI[n-1]=1;
            for (int i = 0; i < length; i++) {
                if (flagI[i]==1) {
                    System.out.print(i+1+" ");
                }
                
            }
            System.out.println();
            flagI[n-1]=0;
        }
        
        flagI[n-1]=1;
        findCombination(n-1, sum-n, flagI);
        
        flagI[n-1]=0;        
        findCombination(n-1, sum, flagI);
    }
    
    public static void sumOfKNumber(int[] a, int n,int sum){
        int [] res = new int[100];
        int k = 0;
        if(n <= 0 || sum <=0){
            return;
        }
        if(k > 0){
            if(sum == a[n - 1]){
                for(int i = k - 1; i>=0;i--){
                    System.out.println(a[k] + "+");
                }
                System.out.println(a[n -1]);
            }
        }
        res[k++] = a[n -1];
        sumOfKNumber(a, n-1, sum -n);
        k--;
        sumOfKNumber(a, n-1, sum);
    }
}
