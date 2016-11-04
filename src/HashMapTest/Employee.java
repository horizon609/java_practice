/**
 * 
 */
package HashMapTest;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月1日
 */
public class Employee {
    private String name;
    
    public Employee( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    @Override
    public String toString() {
        return name;
    }
}
