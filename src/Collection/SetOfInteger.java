package Collection;
/**
 * 
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月28日
 */
public class SetOfInteger {
    public static void main(String[] args){

        List<String> list = new LinkedList<>();
        list.add("ht");
        list.add("hj");
        list.add("hw");
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(Arrays.toString(list.toArray()));
        
        ListIterator<String> listIterator = list.listIterator();
        listIterator.next();
        listIterator.add("hj");
        listIterator.add("hy");
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void example1(){
        Random rand=new Random(47);
        Set<Integer> intset=new HashSet<Integer>();
        for (int i=0;i<30;i++){
            intset.add(i + (1 << 16));
        }
        java.util.Iterator<Integer> iterator=intset.iterator();
        while (iterator.hasNext()){
            System.out.print((iterator.next() - (1 << 16)) +" ");
        }
    }

}
