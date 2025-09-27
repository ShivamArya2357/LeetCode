package Practice.src.warmup;

import java.util.Arrays;

public class LeetCode1552 {

    public static void main(String[] args) {

    }

    public int maxDistance(int[] position, int m) {

        int n = position.length;
        Arrays.sort(position);
        int l = 1;
        int h = position[n - 1] / (m - 1);
        int answer = 0;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (canWePlaceAllBalls(position, n, m, mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return answer;
    }

    private boolean canWePlaceAllBalls(int[] position, int n, int m, int x) {

        int prevBallPos = position[0];
        int ballsPlaced = 1;
        for (int i = 1; i < n; i++) {
            int currBallPos = position[i];
            if (prevBallPos + x <= currBallPos) {
                ballsPlaced++;
                prevBallPos = currBallPos;
            }
        }
        return ballsPlaced == m;
    }
}
