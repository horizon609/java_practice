/**
 * 
 */
package StreamAndFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月16日
 */
public class TextFileTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException{
        Employee[] e = new Employee[3];
        e[0] = new Employee("ht", 210000, 2015, 3, 11);
        e[1] = new Employee("hw", 21000, 2015, 7, 15);
        e[2] = new Employee("hj", 2100, 2015, 5, 30);
        try (PrintWriter pw = new PrintWriter("employee.dat", "UTF-8")){//生成的位置在java_practise下
            writeData(e, pw);
        } 
        
        try(Scanner sc = new Scanner(new FileInputStream("employee.dat"),"UTF-8")){//注意 把资源放在try()里，自带sc.close,
            //outputStream一定要close,才会刷出缓冲区写到文件里面。
            Employee[] arr = readData(sc);
            for(Employee emp:arr){
                System.out.println(emp);
            }
        }
            
         
        
            
    }

    /**
     * @param sc
     * @return
     */
    private static Employee[] readData(Scanner sc) {
        int len = sc.nextInt();
        sc.nextLine();//必须有
        Employee[] e = new Employee[len];
        for(int i = 0; i < len; i++){
            e[i] = readEmployee(sc);
        }
        return e;
    }

   

    /**
     * @param sc
     * @return
     */
    private static Employee readEmployee(Scanner sc) {
        String [] stringArr = sc.nextLine().split("\\|");
        String name = stringArr[0];
        double salary = Double.valueOf(stringArr[1]);
        int year = Integer.valueOf(stringArr[2]);
        int month = Integer.valueOf(stringArr[3]);
        int day = Integer.valueOf(stringArr[4]);
        Employee e = new Employee(name, salary, year, month, day);
        return e;
    }

    /**
     * @param e
     * @param pw
     */
    private static void writeData(Employee[] e, PrintWriter pw) {
        pw.println(e.length);
        for(Employee emp:e){
            writeEmployee(emp,pw);
        }
    }

    /**
     * @param emp
     * @param pw
     */
    private static void writeEmployee(Employee emp, PrintWriter pw) {
        //Calendar里包含了一个Date，而Date里的方法已经过期，所以对于date的操作用Calendar来取代
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(emp.getHireDay());
        pw.println(emp.getName() +"|" + emp.getSalary() + "|" + c.get(Calendar.YEAR) + "|" + (c.get(Calendar.MONTH) + 1)//注意月份这个恶心的坑
                +"|" + c.get(Calendar.DAY_OF_MONTH));
//        pw.flush();
    }

}
