package Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 */
public class LinkedListTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List<String> a = new LinkedList();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        
        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        
        ListIterator<String> aItea = a.listIterator();
        Iterator<String> bItea = b.iterator();
        
        while(bItea.hasNext()){
            if(aItea.hasNext()) aItea.next();
            aItea.add(bItea.next());
        }
         System.out.println(a);
         
         bItea = b.iterator();
         while(bItea.hasNext()){
             bItea.next();
             if(bItea.hasNext()){
                 bItea.next();
                 bItea.remove();
             }
         }
         System.out.println(b);
         
         a.removeAll(b);
         System.out.println(a);
    }

}
