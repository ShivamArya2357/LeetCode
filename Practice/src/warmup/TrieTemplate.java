package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class TrieTemplate {

    private void insert(String word) {

        TrieNode currNode = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (currNode.children.containsKey(currentChar)) {
                currNode = currNode.children.get(currentChar);
            } else {
                TrieNode newNode = new TrieNode();
                currNode.children.put(currentChar, newNode);
                currNode = newNode;
            }
        }
        currNode.isEndOfTheWord = true;
    }

    class TrieNode {

        private Map<Character, TrieNode> children;

        private boolean isEndOfTheWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfTheWord = false;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfTheWord() {
            return isEndOfTheWord;
        }
    }
}
