package Practice.src.warmup;

public class LeetCode160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int countA = 0;
        int countB = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            countA++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            countB++;
            tempB = tempB.next;
        }
        if (countA >= countB) {
            int diff = countA - countB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = countB - countA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return new ListNode(0);
    }
}
