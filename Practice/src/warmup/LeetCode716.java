package Practice.src.warmup;

import org.w3c.dom.Node;

import java.util.*;

public class LeetCode716 {

    public static void main(String[] args) {

    }

    class MaxStack {

        private static final class Node {

            int val;
            Node next;
            Node prev;
            Node(int val) {
                this.val = val;
            }
        }

        Node head = new Node(0);

        Node tail = new Node(0);

        TreeMap<Integer, Deque<Node>> map = new TreeMap<>();

        private boolean isEmpty() {

            return head.next == tail;
        }

        private void addLast(Node node) {

            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            node.next = tail;
            tail.prev = node;
        }

        private void remove(Node node) {

            Node last = node.prev;
            Node next = node.next;
            last.next = next;
            next.prev = last;
            node.prev = null;
            node.next = null;
        }

        public Node last() {
            return tail.prev;
        }

        public MaxStack() {

            head.next = tail;
            tail.prev = head;
        }

        public void push(int val) {

            Node node = new Node(val);
            addLast(node);
            map.computeIfAbsent(val, k -> new ArrayDeque<>()).addLast(node);
        }

        public int pop() {

            if (isEmpty()) {
                return -1;
            }
            Node lastNode = last();
            int val = lastNode.val;
            remove(lastNode);
            Deque<Node> deque = map.get(val);
            deque.removeLast();
            if (deque.isEmpty()) {
                map.remove(val);
            }
            return val;
        }

        public int top() {

            if (isEmpty()) {
                return -1;
            }
            Node lastNode = last();
            int val = lastNode.val;
            return val;
        }

        public int peekMax() {

            if (isEmpty()) {
                return -1;
            }
            return map.lastKey();
        }

        public int popMax() {

            if (isEmpty()) {
                return -1;
            }
            int val = map.lastKey();
            Deque<Node> deque = map.get(val);
            Node node = deque.removeLast();
            if (deque.isEmpty()) {
                map.remove(val);
            }
            remove(node);
            return val;
        }
    }
}
