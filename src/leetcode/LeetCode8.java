/**
 * 
 */
package leetcode;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月18日
 */
public class LeetCode8 {
    /**
     * Implement atoi to convert a string to an integer.
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        int index = 0;
        int sign = 1;
        if(str.charAt(index) == '+'||str.charAt(index)=='-'){
            sign = str.charAt(index) == '+'?1:-1;
            index++;
        }
        int sum = 0;
        while(index < str.length()){
            int value = str.charAt(index) - '0';
            if(value<0||value>9) break;
            //判断溢出：需要了解的一点是：Integer.MAX_VALUE的绝对值比Integer.MIN_VALUE小1.这样主要是为了考虑，当输入>="-2147483648"时（Integer.MIN_VALUE）
            if(sum > Integer.MAX_VALUE/10||sum == Integer.MAX_VALUE/10 && value > Integer.MAX_VALUE % 10)
                return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            sum = sum * 10 + value;
            index++;
        }
        return sum * sign;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
    }

}
