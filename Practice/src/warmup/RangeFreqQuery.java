package Practice.src.warmup;

public class RangeFreqQuery {
    private int[][] bit; // BIT to store frequencies
    private int maxVal; // Maximum value in the array
    private int n; // Size of the array

    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        maxVal = 100000; // Assuming maximum value in the array is 100,000
        bit = new int[maxVal + 1][n + 1]; // BIT for each value from 1 to maxVal

        // Build the BIT by updating frequencies
        for (int i = 0; i < n; i++) {
            update(arr[i], i + 1, 1); // Update BIT for the current value
        }
    }

    // Function to update the BIT for a specific value at a position
    private void update(int value, int pos, int delta) {
        while (pos <= n) {
            bit[value][pos] += delta;
            pos += pos & -pos; // Move to the next index in BIT
        }
    }

    // Function to query the BIT for a specific value up to a given position
    private int query(int value, int pos) {
        int sum = 0;
        while (pos > 0) {
            sum += bit[value][pos];
            pos -= pos & -pos; // Move to the parent index in BIT
        }
        return sum;
    }

    public int query(int left, int right, int value) {
        // Use BIT to calculate the frequency of `value` in range [left, right]
        return query(value, right + 1) - query(value, left);
    }

    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rfq = new RangeFreqQuery(arr);

        // Corrected Queries (1-based indexing for left and right ranges)
        System.out.println(rfq.query(1, 2, 4));  // Output: 1
        System.out.println(rfq.query(1, 12, 33)); // Output: 2
    }
}
