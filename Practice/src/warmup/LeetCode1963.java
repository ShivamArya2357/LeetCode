package Practice.src.warmup;

import java.util.Stack;

public class LeetCode1963 {

    public static void main(String[] args) {

        LeetCode1963 test = new LeetCode1963();
        int ans = test.minSwaps("]][[");
        System.out.println(ans);
    }

    public int minSwaps(String s) {

        int len = s.length();
        int stackSize = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '[') {
                stackSize++;
            } else {
                if (stackSize > 0) {
                    stackSize--;
                }
            }
        }
        int ans = Math.ceilDiv(2 * stackSize, 4);
        return ans;
    }
}
