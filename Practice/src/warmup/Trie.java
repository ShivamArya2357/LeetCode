package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode rootNode;

    public Trie() {
        this.rootNode = new TrieNode();
    }

    private void insert(String word) {

        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            currentNode.children.putIfAbsent(currentChar, new TrieNode());
            currentNode = currentNode.children.get(currentChar);
        }
        currentNode.isEndOfTheWord = true;
    }

    private boolean search(String word) {

        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!currentNode.children.containsKey(currentChar)) {
                return false;
            }
            currentNode = currentNode.children.get(currentChar);
        }
        return currentNode.isEndOfTheWord;
    }

    private boolean startsWith(String word) {

        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            if (!currentNode.children.containsKey(currentChar)) {
                return false;
            }
            currentNode = currentNode.children.get(currentChar);
        }
        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("ape");

        // Search words
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app"));   // true
        System.out.println(trie.search("apex"));  // false

        // Check prefixes
        System.out.println(trie.startsWith("ap")); // true
        System.out.println(trie.startsWith("bat"));
    }

    class TrieNode {

        Map<Character, TrieNode> children;

        boolean isEndOfTheWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfTheWord = false;
        }
    }
}
