package Practice.src.warmup;

public class LeetCode234 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int i = count / 2;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null && i > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr != null) {
                next = curr.next;
            }
            i--;
        }
        if (count % 2 == 1) {
            curr = curr.next;
        }
        return isSame(prev, curr);
    }

    private boolean isSame(ListNode headA, ListNode headB) {

        while (headA != null && headB != null) {
            if (headA.val != headB.val) {
                return false;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }
}
