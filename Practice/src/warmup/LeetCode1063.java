package Practice.src.warmup;

import java.util.Stack;

public class LeetCode1063 {

    public static void main(String[] args) {

    }

    public int numberOfValidSubarrays(int[] arr) {

        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans += stack.peek() - i + 1;
                } else {
                    ans += len - i + 1;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
