package Practice.src.warmup;

import java.util.PriorityQueue;

public class NearlySorted {

    public static void main(String[] args) {

        NearlySorted test = new NearlySorted();
        int[] arr = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
        int k = 2;
        int[] ans = test.nearlySorted(arr, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] nearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }
        int cnt = 0;
        for (int i = k + 1; i < arr.length; i++) {
            int minEle = minHeap.poll();
            arr[cnt++] = minEle;
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            arr[cnt++] = minHeap.poll();
        }
        return arr;
    }
}
