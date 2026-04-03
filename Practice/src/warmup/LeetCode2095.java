package Practice.src.warmup;

public class LeetCode2095 {

    public static void main(String[] args) {

    }

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevNode.next = slow.next;
        return head;
    }
}
