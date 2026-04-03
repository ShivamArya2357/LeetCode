package Practice.src.warmup;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode prevNode = head;
        ListNode currNode = head.next;
        ListNode nextNode = null;
        if (currNode != null) {
            nextNode = currNode.next;
        }
        ListNode newHead = head;
        ListNode newTail = head;
        while (currNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            newHead = currNode;
            currNode = nextNode;
            if (currNode != null) {
                nextNode = currNode.next;
            }
        }
        newTail.next = null;
        return newHead;
    }
}
