package Practice.src.warmup;

import java.math.BigInteger;

public class LeetCode2807 {

    public static void main(String[] args) {

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head.next == null) {
            return head;
        } else {
            ListNode currNode = head;
            ListNode nextNode = head.next;
            while (nextNode != null) {
                int a = currNode.val;
                int b = nextNode.val;
                int gcd = gcd(a, b);
                currNode.next = new ListNode(gcd, nextNode);
                currNode = nextNode;
                nextNode = nextNode.next;
            }
            return head;
        }
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
