package Practice.src.warmup;

public class LeetCode19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= n; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode nextNode = slow.next.next;
        slow.next = nextNode;
        return head;
    }
}
