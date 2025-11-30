package Practice.src.warmup;

public class LeetCode2433 {

    public static void main(String[] args) {

    }

    public int[] findArray(int[] pref) {

        int len = pref.length;
        int prefixSum = 0;
        for (int i = 0; i < len; i++) {
            pref[i] ^= prefixSum;
            prefixSum ^= pref[i];
        }
        return pref;
    }
}
