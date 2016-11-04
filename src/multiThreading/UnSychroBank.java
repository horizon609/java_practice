/**
 * 
 */
package multiThreading;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月4日
 */
public class UnSychroBank {
    private double [] accounts;
    public UnSychroBank(int accountsNumber, double initialBanlance) {
        accounts = new double[accountsNumber];
        for(int i = 0; i < accountsNumber; i++){
            accounts[i] = initialBanlance;
        }
    }
    
    public void transfer(int from, int to, double banlance){
        if(accounts[from] >= banlance){
            System.out.print(Thread.currentThread());
            accounts[from] -= banlance;
            System.out.printf(" %10.2f from %d to %d",banlance,from,to);
            accounts[to] += banlance;
            System.out.printf(" total banlance: %10.2f \n",getTotalBanlance());
        }
    }
    
    public double getTotalBanlance(){
        double totalBanlance = 0;
        for(int i = 0; i < accounts.length; i++){
            totalBanlance += accounts[i];
        }
        return totalBanlance;
    }

}
