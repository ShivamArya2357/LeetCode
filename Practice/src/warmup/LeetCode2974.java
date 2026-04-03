package Practice.src.warmup;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode2974 {

    public static void main(String[] args) {

    }

    public int[] numberGame(int[] nums) {

        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(num -> num));
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }
        int[] ans = new int[n];
        int count = 0;
        while (!pq.isEmpty()) {
            int top1 = pq.poll();
            int top2 = pq.poll();
            ans[count++] = top2;
            ans[count++] = top1;
        }
        return ans;
    }
}
