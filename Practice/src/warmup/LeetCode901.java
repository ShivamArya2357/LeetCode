package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode901 {

    List<Integer> stockPrices = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) {

    }

//    public StockSpanner() {
//    }

    public int next2(int price) {

        int index = stockPrices.size() - 1;
        int count = 1;
        while (!stockPrices.isEmpty() && index >= 0 && price >= stockPrices.get(index)) {
            count += ans.get(index);
            index = index - ans.get(index);
        }
        ans.add(count);
        stockPrices.add(price);
        return count;
    }

    public int next(int price) {

        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
