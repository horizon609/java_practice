/**
 * 
 */
package multiThreading;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月4日
 */
public class SychTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SychBank bank = new SychBank(100, 1000);
        for(int i = 0; i < 100; i++){
            TransferRunnable tfr = new TransferRunnable(bank, 100, 1000);
            Thread t = new Thread(tfr);
            t.start();
        }

    }

}
