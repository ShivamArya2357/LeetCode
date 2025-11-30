package Practice.src.warmup;

public class LeetCode2413 {

    public static void main(String[] args) {

    }

    public int smallestEvenMultiple(int n) {
        return (2 * n) / gcd(n);
    }

    private int gcd(int a) {

        if (a % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
