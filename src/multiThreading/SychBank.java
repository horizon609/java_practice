/**
 * 
 */

package multiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月4日
 */
public class SychBank {
    private double[] accounts;
    private ReentrantLock lock;
    private Condition sufficientFunds;

    public SychBank(int accountsNumber, double initialBanlance) {
        accounts = new double[accountsNumber];
        for (int i = 0; i < accountsNumber; i++) {
            accounts[i] = initialBanlance;
        }
        lock = new ReentrantLock();// 不要忘记初始化2333
        sufficientFunds = lock.newCondition();
    }

    public void transfer(int from, int to, double banlance) throws InterruptedException {
        lock.lock();
        try {
            while (accounts[from] < banlance) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= banlance;
            System.out.printf(" %10.2f from %d to %d", banlance, from, to);
            accounts[to] += banlance;
            System.out.printf(" total banlance: %10.2f \n", getTotalBanlance());
            sufficientFunds.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public double getTotalBanlance() {
        double totalBanlance = 0;
        for (int i = 0; i < accounts.length; i++) {
            totalBanlance += accounts[i];
        }
        return totalBanlance;
    }

    public int size() {
        return accounts.length;
    }

}
