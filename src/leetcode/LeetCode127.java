/**
 * 
 */
package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月23日
 */
public class LeetCode127 {
/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
    /**
     * 注：Set里是不会有重复值的
     * 搜索最小路径，通常使用BFS：http://www.cnblogs.com/developerY/p/3323264.html
     * 参考http://www.cnblogs.com/jianxinzhou/p/4515287.html
     * 完全理解BFS后，解决这个问题就不会存在任何问题了。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList == null || wordList!=null && wordList.size()==0){
            return 0;
        }
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        Map<String,Integer> map = new HashMap<String, Integer>();//integer代表层数，即该元素距起点的距离
        map.put(beginWord, 1);
        while(!q.isEmpty()){
            String top = q.poll();
            int count = map.get(top);
            StringBuilder sb;
            for(int i = 0; i < beginWord.length(); i++){
                sb = new StringBuilder(top);
                for(char c = 'a';c <='z';c++){
                    sb.setCharAt(i,c);
                    if(sb.toString().equals(top))continue;//排除了输入和输出相等，但是不可能通过wordList达到的情况
                    if(sb.toString().equals(endWord)) return count+1;//代表现有的String元素改了一个字母后和endWord相等，但是不包括现有String改动0个和endWord相等
                    if(wordList.contains(sb.toString())){//排除了没有处理临时字符串和已经找到了完整路径的情况，只剩下：临时串有一个字母改变的情况
                        q.offer(sb.toString());
                        map.put(sb.toString(), count+1);
                        wordList.remove(sb.toString());
                    }
                }
            }
        }
        return 0;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> wordList = new HashSet<String>((Arrays.asList("abc","efg","hig","ddd","dot","zzz")));
        System.out.println(ladderLength("dot", "dot", wordList));
    }

}
