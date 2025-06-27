package Practice.src.warmup;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode1472 {

    public static void main(String[] args) {

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        String currentUrl = browserHistory.back(1);
        System.out.println(currentUrl);
        currentUrl = browserHistory.back(1);
        System.out.println(currentUrl);
        currentUrl = browserHistory.forward(1);
        System.out.println(currentUrl);
        browserHistory.visit("linkedin.com");
        currentUrl = browserHistory.forward(2);
        System.out.println(currentUrl);
        currentUrl = browserHistory.back(2);
        System.out.println(currentUrl);
        currentUrl = browserHistory.back(7);
        System.out.println(currentUrl);
    }
}

class BrowserHistory {

    private String homepage;

    private Stack<String> history;

    private List<String> forwardHistory;

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        this.history = new Stack<>();
        this.forwardHistory = new LinkedList<>();
        history.push(homepage);
    }

    public void visit(String url) {

        history.push(url);
        this.forwardHistory = new LinkedList<>();
    }

    public String back(int steps) {

        if (history.size() <= steps) {
            return homepage;
        } else {
            while (!history.isEmpty() && steps > 0) {
                forwardHistory.addFirst(history.pop());
                steps--;
            }
            if (!history.isEmpty()) {
                return history.peek();
            } else {
                return null;
            }
        }
    }

    public String forward(int steps) {

        if (!forwardHistory.isEmpty()) {
            for (int i = 0; i < Math.min(forwardHistory.size(), steps); i++) {
                history.push(forwardHistory.get(i));
                forwardHistory.removeFirst();
            }
        }
        return history.peek();
    }
}
