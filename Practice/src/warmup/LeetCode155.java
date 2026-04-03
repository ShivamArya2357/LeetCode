package Practice.src.warmup;

import java.util.Stack;

public class LeetCode155 {

    public static void main(String[] args) {

    }

    class MinStack {

        Stack<int[]> minStack;

        public MinStack() {
            this.minStack = new Stack<>();
        }

        public void push(int val) {

            if (!minStack.isEmpty()) {
                int[] peek = minStack.peek();
                minStack.push(new int[]{val, Math.min(val, peek[1])});
            } else {
                minStack.push(new int[]{val, val});
            }
        }

        public void pop() {

            if (!minStack.isEmpty()) {
                minStack.pop();
            }
        }

        public int top() {

            if (!minStack.isEmpty()) {
                return minStack.peek()[0];
            } else {
                return -1;
            }
        }

        public int getMin() {

            if (!minStack.isEmpty()) {
                return minStack.peek()[1];
            } else {
                return -1;
            }
        }
    }
}
