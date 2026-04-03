package Practice.src.warmup;

import java.util.List;

public class LeetCode328 {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail1 = head;
        ListNode tail2 = head.next;
        ListNode temp = tail2.next;
        ListNode secHead = tail2;
        int count = 3;
        while (temp != null) {
            if (count % 2 == 1) {
                tail1.next = temp;
                tail1 = tail1.next;
            } else {
                tail2.next = temp;
                tail2 = tail2.next;
            }
            temp = temp.next;
            count++;
        }
        tail1.next = secHead;
        tail2.next = null;
        return head;
    }
}
