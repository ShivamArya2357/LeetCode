package Practice.src.warmup;

import java.util.*;

public class LeetCode56 {

    public static void main(String[] args) {

        LeetCode56 test = new LeetCode56();
        int[][] intervals = new int[][]{{1,4},{4,5}};
        test.merge(intervals);
    }

//    public int[][] merge(int[][] intervals) {
//
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        Stack<int[]> stack = new Stack<>();
//        for (int[] interval : intervals) {
//            if (stack.isEmpty()) {
//                stack.push(interval);
//            } else {
//                int currStart = interval[0];
//                int currEnd = interval[1];
//                while (!stack.isEmpty()) {
//                    int[] top = stack.peek();
//                    if (top[1] >= currStart) {
//                        currStart = Math.min(top[0], currStart);
//                        currEnd = Math.max(top[1], currEnd);
//                        stack.pop();
//                    } else {
//                        break;
//                    }
//                }
//                stack.push(new int[]{currStart, currEnd});
//            }
//        }
//        List<int[]> res = new ArrayList<>();
//        while (!stack.isEmpty()) {
//            int[] top = stack.pop();
//            res.add(top);
//        }
//        return res.toArray(new int[res.size()][2]);
//    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] interval : intervals) {
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= interval[0]) {
                int currStart = Math.min(res.get(res.size() - 1)[0], interval[0]);
                int currEnd = Math.max(res.get(res.size() - 1)[1], interval[1]);
                res.removeLast();
                res.addLast(new int[]{currStart, currEnd});
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
