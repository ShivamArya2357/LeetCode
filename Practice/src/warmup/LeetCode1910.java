package Practice.src.warmup;

import java.util.Stack;

public class LeetCode1910 {

    public static void main(String[] args) {

        LeetCode1910 test = new LeetCode1910();
        String res = test.removeOccurrences("daabcbaabcbc", "abc");
        System.out.println(res);
    }

    public String removeOccurrences(String s, String part) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= part.length() && checkMatch(stack, part)) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if (!sb.isEmpty()) {
            return sb.reverse().toString();
        } else {
            return "";
        }
    }

    private boolean checkMatch(Stack<Character> stack, String part) {

        Stack<Character> tmpStack = new Stack<>();
        tmpStack.addAll(stack);
        for (int i = 0; i < part.length(); i++) {
            if (part.charAt(part.length() - i - 1) != tmpStack.pop()) {
                return false;
            }
        }
        return true;
    }
}
