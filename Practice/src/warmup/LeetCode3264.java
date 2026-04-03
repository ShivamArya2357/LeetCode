package Practice.src.warmup;

import java.util.PriorityQueue;

public class LeetCode3264 {

    public static void main(String[] args) {

        LeetCode3264 test = new LeetCode3264();
        int[] nums = {1, 2};
        int k = 3;
        int multiplier = 4;
        int[] ans = test.getFinalState(nums, k, multiplier);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((num1, num2) -> {
            if (num1[0] != num2[0]) {
                return Integer.compare(num1[0], num2[0]);
            }
            return Integer.compare(num1[1], num2[1]);
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] top = pq.poll();
            nums[top[1]] = multiplier * top[0];
            int newNum = multiplier * top[0];
            pq.add(new int[]{newNum, top[1]});
        }
        return nums;
    }
}
