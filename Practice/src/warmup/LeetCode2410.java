package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode2410 {

    public static void main(String[] args) {

    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = trainers.length;
        int m = players.length;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
