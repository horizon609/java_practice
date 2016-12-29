/**
 * 
 */

package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月29日
 */
public class JudgeBinarySearchTree {
    public static void judgeBinarySearchTree(int[] a, int n, int i, Set<Integer> arr) {
        if (i < n / 2) {
            int lChild = i * 2 + 1;
            int rChild = lChild + 1;
            if (a[lChild] != -1) {
                judgeBinarySearchTree(a, n, lChild, arr);
            }

            if (a[rChild] != -1) {
                judgeBinarySearchTree(a, n, rChild, arr);
            }

            if (a[lChild] != -1 && a[lChild] > a[i] || a[rChild] != -1 && a[rChild] < a[i]) {
                return;
            }
            arr.remove(a[i]);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {
                5, 3, 6, 1, -1, 2, 8
        };
        int n = a.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n / 2; i++) {
            set.add(a[i]);
        }
        judgeBinarySearchTree(a, 7, 0, set);
        if(set.size()==0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

}
