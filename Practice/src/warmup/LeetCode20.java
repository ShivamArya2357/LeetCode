package Practice.src.warmup;

import java.util.Stack;

public class LeetCode20 {

    public static void main(String[] args) {

        LeetCode20 test = new LeetCode20();
        boolean ans = test.isValid("([])");
        System.out.println(ans);
    }

    public boolean isValid(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && isValidComb(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isValidComb(Character peekCharacter, char currentChar) {

        return (peekCharacter == '(' && currentChar == ')') ||
                (peekCharacter == '[' && currentChar == ']') ||
                (peekCharacter == '{' && currentChar == '}');
    }
}
