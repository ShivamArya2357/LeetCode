package Practice.src.warmup;

public class LeetCode191 {

    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {

        int ans = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}
