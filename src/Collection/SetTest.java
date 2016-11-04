package Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 */
public class SetTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Set<String> words = new HashSet<>();
        long totalTime = 0;
        
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis();
            totalTime += callTime;
        }
        System.out.println(".");
        
        Iterator<String> iter = words.iterator();
        for(int i = 0; i<= 20;i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " distinct words." + totalTime + " milliseconds.");
    }

}
