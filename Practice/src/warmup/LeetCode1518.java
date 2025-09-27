package Practice.src.warmup;

public class LeetCode1518 {

    public static void main(String[] args) {

    }

    public int numWaterBottles(int n, int m) {

        int totalEmptyWaterBottles = n;
        while (n >= m) {
            totalEmptyWaterBottles += n / m;
            n = n % m + n / m;
        }
        return totalEmptyWaterBottles;
    }
}
