/**
 * 
 */
package TreeSetTest;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortedSet<Item> sortedSet = new TreeSet<Item>();
        sortedSet.add(new Item(1234,"Toaster"));
        sortedSet.add(new Item(5678,"widget"));
        sortedSet.add(new Item(9912,"Modem"));
        System.out.println(sortedSet);
        
        SortedSet<Item> des = new TreeSet<Item>(new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                String desA = o1.getDescription();
                String desB = o2.getDescription();
                return desA.compareTo(desB);
            }
        });
        
        des.addAll(sortedSet);
        System.out.println(des);

    }

}
