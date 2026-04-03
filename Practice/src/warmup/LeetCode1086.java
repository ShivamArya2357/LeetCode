package Practice.src.warmup;

import java.util.*;
import java.util.function.Function;

public class LeetCode1086 {

    public static void main(String[] args) {

        LeetCode1086 test = new LeetCode1086();
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60},
        {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        int[][] ans = test.highFive(items);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public int[][] highFive(int[][] items) {

        int n = items.length;
        Map<Integer, PriorityQueue<Integer> > pqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int stdId = items[i][0];
            int score = items[i][1];
            PriorityQueue<Integer> minHeap = pqMap.computeIfAbsent(stdId, key -> new PriorityQueue<>());
            minHeap.add(score);
            if (minHeap.size() > 5) {
                minHeap.poll();
            }
        }
        List<Integer> ids = new ArrayList<>(pqMap.keySet());
        Collections.sort(ids);
        int[][] ans = new int[pqMap.size()][2];
        int cnt = 0;
        for (Integer id : ids) {
            PriorityQueue<Integer> minHeap = pqMap.get(id);
            int sum = 0;
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            int avg = sum / 5;
            ans[cnt++] = new int[]{id, avg};
        }
        return ans;
    }
}
