package Practice.src.warmup;

public class LeetCode1011 {

    public static void main(String[] args) {

    }

    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int l = 0;
        int h = 0;
        for (int i = 0; i < n; i++) {
            l = Math.max(l, weights[i]);
            h += weights[i];
        }
        while (l < h) {
            int newCapacity = l + (h - l) / 2;
            if (canShipInDays(weights, newCapacity, n, days)) {
                h = newCapacity;
            } else {
                l = newCapacity + 1;
            }
        }
        return l;
    }

    private boolean canShipInDays(int[] weights, int newCapacity, int n, int days) {

        int sum = 0;
        int dayCount = 1;
        for (int i = 0; i < n; i++) {
            if (sum + weights[i] > newCapacity) {
                dayCount++;
                sum = 0;
            }
            sum += weights[i];
            if (dayCount > days) {
                return false;
            }
        }
        return true;
    }
}
