package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode57 {

    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[0];
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        while (i < n && intervals[i][0] < newInterval[1]) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{newStart, newEnd});
        while (i < n) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    private boolean isOverlappingRange(int currStart, int currEnd, int newStart, int newEnd) {

        return (newStart >= currStart && newEnd <= currEnd) ||
                (newStart <= currStart && newEnd < currEnd) ||
                (newStart >= currStart && newEnd > currEnd);
    }
}
