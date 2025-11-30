package Practice.src.warmup;

public class LeetCode1381 {

    public static void main(String[] args) {

        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);

        int topElement = customStack.pop();
        System.out.println(topElement);

        customStack.push(2);
        customStack.push(3);
        customStack.push(4);

        customStack.increment(5, 100);
        customStack.increment(2, 100);

        topElement = customStack.pop();
        System.out.println(topElement);

        topElement = customStack.pop();
        System.out.println(topElement);

        topElement = customStack.pop();
        System.out.println(topElement);

        topElement = customStack.pop();
        System.out.println(topElement);
    }
}

class CustomStack {

    private int maxSize;

    private int[] increments;

    private int[] stack;

    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.increments = new int[maxSize + 1];
        this.stack = new int[maxSize + 1];
        this.top = 0;
    }

    public void push(int x) {

        if (top < maxSize) {
            stack[++top] = x;
        }
    }

    public int pop() {

        int topEle = -1;
        if (top > 0) {
            if (increments[top] > 0) {
                topEle = stack[top] + increments[top];
                increments[top - 1] += increments[top];
                increments[top] = 0;
            } else {
                topEle = stack[top];
            }
            top--;
        }
        return topEle;
    }

    public void increment(int k, int val) {

        if (k <= top) {
            increments[k] += val;
        } else {
            increments[top] += val;
        }
    }
}
