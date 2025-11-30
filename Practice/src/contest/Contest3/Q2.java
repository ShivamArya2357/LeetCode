package Practice.src.contest.Contest3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2 {

    public static void main(String[] args) {

        Q2 q2 = new Q2();
        int[] arrivals = {1,2,1,3,1};
        int w = 4;
        int m = 2;
        int ans = q2.minArrivalsToDiscard(arrivals, w, m);
        System.out.println(ans);
    }

    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {

        int n = arrivals.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int i = 0;
        Set<Integer> discardedArrivals = new HashSet<>();
        while (i < w - 1) {
            int arrival = arrivals[i];
            int freq = freqMap.getOrDefault(arrival, 0);
            if (freq + 1 > m) {
                discardedArrivals.add(i);
            } else {
                freqMap.put(arrival, freq + 1);
            }
            i++;
        }
        while (i < n) {
            int arrival = arrivals[i];
            int freq = freqMap.getOrDefault(arrival, 0);
            if (freq + 1 > m) {
                discardedArrivals.add(i);
            } else {
                freqMap.put(arrival, freq + 1);
            }
            int start = i - w + 1;
            if (start >= 0 && !discardedArrivals.contains(start)) {
                int oldArrival = arrivals[start];
                freqMap.put(oldArrival, freqMap.get(oldArrival) - 1);
            }
            i++;
        }
        return discardedArrivals.size();
    }
}
