package Practice.src.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode386 {

    private TrieNode rootNode = new TrieNode();

    private List<Integer> ans = new ArrayList<>();

    class TrieNode {

        Map<Integer, TrieNode> children;

        boolean isEndOfTheDigit;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfTheDigit = false;
        }
    }

    private void insert(int number) {

        TrieNode currentNode = rootNode;
        int totalDigit = (int) Math.log10(number);
        while (totalDigit >= 0) {
            int digit = number / ((int) Math.pow(10, totalDigit));
            currentNode.children.putIfAbsent(digit, new TrieNode());
            currentNode = currentNode.children.get(digit);
            number = number % ((int) Math.pow(10, totalDigit));
            totalDigit--;
        }
        currentNode.isEndOfTheDigit = true;
    }

    public static void main(String[] args) {

        LeetCode386 test = new LeetCode386();
        test.lexicalOrder(13);
    }

    public List<Integer> lexicalOrder(int n) {

        for (int i = 1; i <= n; i++) {
            insert(i);
        }
        TrieNode currentNode = rootNode;
        sortNumbers(currentNode, 0);
        return ans;
    }

    private void sortNumbers(TrieNode currentNode, int currentNum) {

        Map<Integer, TrieNode> children = currentNode.children;
        for (Map.Entry<Integer, TrieNode> entry : children.entrySet()) {
            Integer currentDigit = entry.getKey();
            currentNode = entry.getValue();
            int newNum = currentNum * 10 + currentDigit;
            if (currentNode.isEndOfTheDigit) {
                ans.add(newNum);
            }
            sortNumbers(entry.getValue(), newNum);
        }
    }
}
