/**
 * 
 */

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月21日
 */
public class FullPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        permutation1("abc", "", 3);

    }
    
    public static void permutation1(String s, String result,int len){
//        if(result.length() == len){
//            System.out.println(result);
//        }else{
//            for(int i = 0; i < len; i++){
//                if(result.indexOf(s.charAt(i)) < 0){
//                    permutation1(s, result+=s.charAt(i), len);
//                }
//            }
//        }
        if(result.length()==len){            //表示遍历完了一个全排列结果
            System.out.println(result);
           }
           else{
               for(int i=0;i<s.length();i++){
                   if(result.indexOf(s.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                       //System.out.println("字母："+str.charAt(i));
                       permutation1(s, result+s.charAt(i), len);
                   }
               } 
           }
    }

}
