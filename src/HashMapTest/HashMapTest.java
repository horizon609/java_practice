/**
 * 
 */
package HashMapTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月1日
 */
public class HashMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<String, Employee>();
        map.put("274-8234", new Employee("ht"));
        map.put("736-2358", new Employee("hj"));
        map.put("342-2348", new Employee("hw"));
        map.put("432-8231", new Employee("hy"));
        
        System.out.println(map);
        
        map.remove("432-8231");
        System.out.println(map);
        
        map.put("342-2348", new Employee("hq"));
        System.out.println(map);
        
        for(Map.Entry<String, Employee> entry : map.entrySet()){
            String phoneNum = entry.getKey();
            Employee e = entry.getValue();
            System.out.println("phoneNum: " + phoneNum + ", employee's name: " + e.getName());
        }
        
        Map unmodifyMap = Collections.unmodifiableMap(map);
        unmodifyMap.remove("274-8234");//throw java.lang.UnsupportedOperationException
        
        Map.Entry<String, Employee> single = new Map.Entry() {
            
            @Override
            public Object getKey() {
                return "123-4567";
            }

            @Override
            public Object getValue() {
                return "zz";
            }

            @Override
            public Object setValue(Object value) {
                return null;
            }
        };
        map.entrySet().add(single);//throw java.lang.UnsupportedOperationException
        map.entrySet().remove("432-8231");//执行成功
        System.out.println(map);
    }

}
