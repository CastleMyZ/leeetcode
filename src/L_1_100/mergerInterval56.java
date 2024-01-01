package L_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergerInterval56 {
    /**
     * 这道题一开始的关键是比较器如何去写，要知道先得给intervals排序
     * 合并区间的题都先给区间排序
     * 这道题的思路其实很简单，就是按照数组左区间进行排序，然后如果左区间小于end，就是重叠了
     * 要不然开一个新区间
     */
    class Solution {
        class Range implements Comparable<Range> {
            int l, r;
            public Range(int l, int r) {
                this.l = l;
                this.r = r;
            }
            public int compareTo(Range o) {
                return Integer.compare(l, o.l);
            }
        }
        int N = 10010;
        Range[] ranges;
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            ranges = new Range[n];
            for (int i = 0;i < n;i ++) {
                ranges[i] = new Range(intervals[i][0], intervals[i][1]);
            }
            Arrays.sort(ranges, 0, n);
            List<int[]> re = new ArrayList<>();
            int start = ranges[0].l;
            int end = ranges[0].r;
            for (int i = 1;i < n;i ++) {
                if (ranges[i].l <= end) {
                    end = Math.max(end, ranges[i].r);
                } else {
                    re.add(new int[]{start, end});
                    start = ranges[i].l;
                    end = ranges[i].r;
                }
            }
            re.add(new int[]{start, end});
            int[][] res = new int[re.size()][2];
            for (int i = 0;i < re.size();i ++) {
                res[i] = re.get(i);
            }
            return res;
        }

    }
}
