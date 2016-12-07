/**
 * 
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals. For
 * example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年12月7日
 */
public class LeetCode56 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Interval i = new Interval(1, 3);
        Interval j = new Interval(2, 6);
        Interval k = new Interval(8, 10);
        Interval l = new Interval(15, 18);
        List<Interval> intervals = new ArrayList<LeetCode56.Interval>();
        intervals.add(i);
        intervals.add(j);
        intervals.add(k);
        intervals.add(l);
        System.out.println(intervals.toString());
        System.out.println(merge(intervals));
        List<Interval> non = new ArrayList<LeetCode56.Interval>();
        System.out.println(merge(non));
    }

    /**
     * 注意边界条件
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null)
            return null;
        if (intervals.size() < 2)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= e) {
                e = max(e, interval.end);
            } else {
                res.add(new Interval(s, e));
                s = interval.start;
                e = interval.end;
            }
        }
        res.add(new Interval(s, e));
        return res;
    }

    /**
     * @param e
     * @param end
     * @return
     */
    private static int max(int e, int end) {
        return e > end ? e : end;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

}
