package Practice.src.warmup;

import java.util.*;

public class LeetCode22 {

    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {

        LeetCode22 test = new LeetCode22();
        List<String> ans = test.generateParenthesis(3);
        System.out.println(ans);
    }

    public List<String> generateParenthesis(int n) {

        char[] path = new char[2 * n];
        generate(path, n, 2 * n, 0, 0, 0);
        return ans;
    }

    public void generate(char[] path, int n, int len, int index, int open, int close) {

        if (index == len) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[index] = '(';
            generate(path, n, len, index + 1, open + 1, close);
        }
        if (close < open) {
            path[index] = ')';
            generate(path, n, len, index + 1, open, close + 1);
        }
    }

    private boolean isValidParenthesis(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
