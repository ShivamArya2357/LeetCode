package Practice.src.warmup;

public class LeetCode1343 {

    public static void main(String[] args) {

    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        int j = k - 1;
        int ans = 0;
        while (j < n) {
            sum += arr[j];
            double divi = sum / (double) k;
            if (divi >= threshold) {
                ans++;
            }
            sum -= arr[j - k + 1];
            j++;
        }
        return ans;
    }
}
