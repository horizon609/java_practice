/**
 * 
 */

package multiThreading;

import java.util.Random;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月4日
 */
public class TransferRunnable implements Runnable {
    private SychBank mBank;
    private int mAccount;
    private double mMaxBanlance;
    private static final int DELAY = 10;

    public TransferRunnable(SychBank mBank, int mAccount, double mMaxBanlance) {
        this.mBank = mBank;
        this.mAccount = mAccount;
        this.mMaxBanlance = mMaxBanlance;
    }

    @Override
    public void run() {
        try {
            while (true) {
                double amount = mMaxBanlance * Math.random();
                int from = (int) (mAccount * Math.random());
                int to = (int) (mAccount * Math.random());
                mBank.transfer(from, to, amount);
                Thread.sleep((int) Math.random() * DELAY);
            }
        } catch (InterruptedException e) {
            // nothing..
        }
    }

}
