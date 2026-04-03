package Practice.src.warmup;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode215 {

    Random random = new Random();

    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {

        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int target = n - k;
        while (l <= h) {
            int p = partition(nums, l, h, l + random.nextInt(h - l + 1));
            if (p == target) {
                return nums[p];
            } else if (p < k) {
                l = p + 1;
            } else {
                h = p - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int h, int pivotIndex) {

        int idx = l;
        swap(nums, pivotIndex, h);
        for (int i = l; i < h; i++) {
            if (nums[i] < nums[pivotIndex]) {
                swap(nums, idx, i);
                idx++;
            }
        }
        swap(nums, idx, pivotIndex);
        return idx;
    }

    private void swap(int[] nums, int i1, int i2) {

        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
