package Collection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 * 优先队列是一个小根堆，每次加add到数组尾部，会调整排序，所以按数组输出并不是排好序的顺序。但是remove是每次都从堆顶取出数据（最小值），之后会重新对树进行排序调整
 */
public class PriorityQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue();
        pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910,Calendar.JUNE,22));
        
        System.out.println("Iterating over elements...");
        for(GregorianCalendar date :pq){
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("removing elements...");
        while(!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }

    }

}
