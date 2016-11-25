/**
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年11月24日
 */
public class LeetCode126 {
    /**
     * 参考https://discuss.leetcode.com/topic/68227/ac-commented-java-solution-using-iterative-bidirectional-bfs-and-recursive-dfs-to-create-result
     * 确实是使用了BFS和DFS，但是不是通过BFS直接求出最短路径长度（没那么简单），而是求出最短路径的过程量，即用Map<String,List<String> neighbors保存最短路径中从开始节点到他的邻居节点的记录。
     * 得到neighbors就很容易通过DFS遍历出所有最短路径。
     * 我之前思路在BFS这里出现了问题：使用的是Map<String,Integer>记录每个节点和其到根节点的距离，这种情况下用dfs求出来的是错的，因为里面有交叉的状况。
     * TODO：补图
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        //To record the neighbors of each word with direction to endWord
        Map<String, List<String>> neighbors = new HashMap<>();
        //To prevent dead loop, I prefer signing nodes visited 
        //rather than the way to remove visited nodes from wordList, 
        //trading off space complexity for time and no need to revise input, which is proper.
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        //Bidirectional BFS to find neighbors
        findNeighbors(begin, end, neighbors, wordList, visited);
        List<String> ans = new ArrayList<>(Arrays.asList(beginWord));
        //DFS to create paths from beginWord to endWord
        getResult(beginWord, endWord, neighbors, ans, result);
        return result;
    }
    private static void findNeighbors(Set<String> begin, Set<String> end, Map<String, List<String>> neighbors, Set<String> wordList, Set<String> visited) {
        //If BFS from the end, we should insert neighbors of each word reversively
        boolean isReverse = false;
        while(!begin.isEmpty()) {
            //Always use the smaller set to iterate.
            if (begin.size() > end.size()) {
                Set<String> tmp = end;
                end = begin;
                begin = tmp;
                isReverse = !isReverse;
            }
            //To store the next level
            Set<String> alternative = new HashSet<>();
            //To signal there is a shortest path in this level
            boolean done = false;
            for (String cur : begin) {
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i ++) {
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        char pre = chars[i];
                        chars[i] = ch;
                        String tmp = new String(chars);
                        //To reversively insert neighbors
                        String key = isReverse ? tmp : cur;
                        String val = isReverse ? cur : tmp;
                        
                        List<String> list = neighbors.containsKey(key) ? neighbors.get(key) : new ArrayList<String>();
                        if (end.contains(tmp)) {
                            list.add(val);
                            neighbors.put(key, list);
                            //If in this level there is a shortest path, no more bfs.
                            alternative.clear();
                            done = true;
                        }
                        if (!done && !visited.contains(tmp) && wordList.contains(tmp)) {
                            alternative.add(tmp);
                            list.add(val);
                            neighbors.put(key, list);
                        }
                        chars[i] = pre;
                    }
                }
            }
            //If no more bfs needed, begin set is empty.
            begin = alternative;
            visited.addAll(alternative);
        }
    }
    private static void getResult(String beginWord, String endWord, Map<String, List<String>> neighbors,List<String> ans, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<String>(ans));
            return;
        }
        if (!neighbors.containsKey(beginWord)) return;
        for (String cur : neighbors.get(beginWord)) {
            ans.add(cur);
            getResult(cur, endWord, neighbors, ans, result);
            ans.remove(ans.size() - 1);
        }
    }
    

//    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
//        List<List<String>> res = new ArrayList<List<String>>();
//        List<String> temp = new ArrayList<String>();
//        Queue<String> q = new LinkedList<String>();
//        Map<String,Integer> map = new HashMap<String, Integer>();
//        q.offer(beginWord);
//        map.put(beginWord, 1);
//        temp.add(beginWord);
////        return dfs(res,temp,"",endWord,1,wordList,q,map);
//        //得到hashMap
//        int count = 0;
//        while(!q.isEmpty()){
//            String top = q.poll();
//            count = map.get(top);
//            StringBuilder sb; 
//            for(int i = 0; i < endWord.length();i++){
//                sb = new StringBuilder(top);
//                for(char c = 'a';c<='z';c++){
//                    sb.setCharAt(i, c);
//                    if(sb.toString().equals(top)) continue;
//                    if(wordList.contains(sb.toString())||sb.toString().equals(endWord)){
//                        map.put(sb.toString(), count+1);
//                        q.offer(sb.toString());
//                        wordList.remove(sb.toString());
//                    }
//                }
//            }
//        }
//        //count became MaxDepth
//        System.out.println(map);
//        dfs(res,temp,beginWord,beginWord,endWord,count,map);
//        return res;
//    }
//    /**
//     * @param res
//     * @param temp
//     * @param beginWord
//     * @param string
//     * @param endWord
//     * @param i
//     * @param map
//     */
//    private static void dfs(List<List<String>> res, List<String> temp, String beginWord,
//            String cur, String endWord, int MaxDepth, Map<String, Integer> map) {
//        
//        if(beginWord!=cur&&cur.equals(endWord)){
//            res.add(new ArrayList<String>(temp));
//        }
//        int depth = map.get(cur);
//        if(depth==MaxDepth) return;
//        for(Map.Entry<String,Integer> em :map.entrySet()){
//            if(em.getValue() == depth + 1){
//                temp.add(em.getKey());
//                dfs(res, temp, beginWord, em.getKey(), endWord, MaxDepth, map);
//                temp.remove(temp.size()-1);
//            }
//        }
//    }
//    private static List<List<String>> dfs(List<List<String>> res,List<String> temp, String CurrentWord,String endWord,int height,Set<String> wordList, Queue<String> q,Map<String,Integer> map){
////        if(CurrentWord.equals(endWord)){
////            res.add(new ArrayList(temp));
////        }
//        while(!q.isEmpty()){
//            String top = q.poll();
//            int count = map.get(top);
//            StringBuilder sb; 
//            for(int i = 0; i < endWord.length();i++){
//                sb = new StringBuilder(top);
//                for(char c = 'a';c<='z';c++){
//                    sb.setCharAt(i, c);
//                    if(sb.toString().equals(top)) continue;
//                    if(wordList.contains(sb.toString())||sb.toString().equals(endWord)){
//                        map.put(sb.toString(), count+1);
//                        q.offer(sb.toString());
//                        wordList.remove(sb.toString());
////                        temp.add(sb.toString());
////                        dfs(res,temp,sb.toString(),endWord,1,wordList,q,map);
////                        temp.remove(temp.size()-1);
//                    }
//                }
//            }
//        }
////        return res;
//        
//    }

    

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
//        System.out.println(findLadders("hit", "cog", wordList));
        findLadders("hit", "cog", wordList);
    }

}
