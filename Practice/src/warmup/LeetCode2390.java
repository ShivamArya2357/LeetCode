package Practice.src.warmup;

import java.util.Stack;

public class LeetCode2390 {

    public static void main(String[] args) {

    }

    public String removeStars(String s) {

        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty() && s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.append(s.charAt(index));
        }
        if (!sb.isEmpty()) {
            return sb.reverse().toString();
        } else {
            return "";
        }
    }
}
