package Practice.src.warmup;

import java.util.*;

public class LeetCode2987 {

    public static void main(String[] args) {

        LeetCode2987 test = new LeetCode2987();
        int[] prices = new int[]{1, 2, 2, 2, 2, 2};
        List<Integer> ans = test.findExpensiveCities(prices, 2);
        System.out.println(ans);
    }

    List<Integer> findExpensiveCities(int[] prices, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = prices.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int currNum = prices[i];
            int numGreaterThanCurrNum = 0;
            for (int j = currNum + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    numGreaterThanCurrNum += map.get(j);
                }
            }
            temp[i] = numGreaterThanCurrNum;
            if (i - k >= 0) {
                int numToRemove = prices[i - k];
                int freq = map.get(numToRemove);
                if (freq > 1) {
                    map.put(numToRemove, freq - 1);
                } else {
                    map.remove(numToRemove);
                }
            }
            map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
        }
        map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int currNum = prices[i];
            int numGreaterThanCurrNum = 0;
            for (int j = currNum + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    numGreaterThanCurrNum += map.get(j);
                }
            }
            temp[i] += numGreaterThanCurrNum;
            if (i + k < n) {
                int numToRemove = prices[i + k];
                int freq = map.get(numToRemove);
                if (freq > 1) {
                    map.put(numToRemove, freq - 1);
                } else {
                    map.remove(numToRemove);
                }
            }
            map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (temp[i] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}
