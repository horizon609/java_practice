/**
 * 
 */
package Collection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月2日
 */
public class CollectionArraySwitch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] values = {"hj","ht","hw","hy"};
        HashSet<String> staff = new HashSet<>(Arrays.asList(values));
        System.out.println(staff);
    }

}
