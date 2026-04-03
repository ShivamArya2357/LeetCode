package Practice.src.warmup;

public class LeetCode148 {

    public static void main(String[] args) {

        LeetCode148 test = new LeetCode148();
        int[] arr = {4,2,1,3};
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        ListNode head = test.sortList(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode sortList2(ListNode head) {


    }

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode start) {

        if (start.next == null) {
            return start;
        }
        ListNode mid = findMiddle(start);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = mergeSort(start);
        ListNode right = mergeSort(rightHead);
        return twoPointer(left, right);
    }

    private ListNode twoPointer(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ListNode temp = head1.next;
                tail.next = head1;
                tail = head1;
                head1.next = null;
                head1 = temp;
            } else {
                ListNode temp = head2.next;
                tail.next = head2;
                tail = head2;
                head2.next = null;
                head2 = temp;
            }
        }
        while (head1 != null) {
            tail.next = head1;
            tail = tail.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            tail.next = head2;
            tail = tail.next;
            head2 = head2.next;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode start) {

        ListNode slow = start;
        ListNode fast = start;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
