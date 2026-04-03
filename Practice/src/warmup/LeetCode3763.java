package Practice.src.warmup;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode3763 {

    public static void main(String[] args) {

    }

    public int maxTotalSum(int[] nums, int[] threshold) {

        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (idx1, idx2) -> threshold[idx2] - threshold[idx1]);
        int step = 1;
        int ans = 0;
        int i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> num2 - num1);
        while (true) {
            while (step >= threshold[idx[i]]) {
                maxHeap.offer(nums[idx[i]]);
                i++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            ans += maxHeap.poll();
            step++;
        }
        return ans;
    }
}
