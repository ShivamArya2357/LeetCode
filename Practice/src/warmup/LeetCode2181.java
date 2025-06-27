package Practice.src.warmup;

public class LeetCode2181 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0, null);
        ListNode currentNode = head;
        currentNode.next = new ListNode(3, null);
    }

    public ListNode mergeNodes(ListNode head) {

        int count = 0;
        ListNode newHead = head;
        ListNode prevNode = null;
        ListNode currentNode = head;
        currentNode = currentNode.next;
        while (currentNode != null) {
            if (currentNode.val != 0) {
                count += currentNode.val;
            } else {
                head.val = count;
                prevNode = head;
                head = head.next;
                count = 0;
            }
            currentNode = currentNode.next;
        }
        prevNode.next = null;
        return newHead;
    }
}
