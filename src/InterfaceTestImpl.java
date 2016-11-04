/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月1日
 */
public abstract class InterfaceTestImpl implements InterfaceTest {

    /* (non-Javadoc)
     * @see InterfaceTest#test1()
     */
    @Override
    public void test1() {
        System.out.println("test1");
    }

    public abstract void test2();

}
