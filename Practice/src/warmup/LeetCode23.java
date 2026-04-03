package Practice.src.warmup;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            ListNode currNode = minHeap.poll();
            ListNode nextNode = currNode.next;
            tail.next = currNode;
            tail = tail.next;
            if (nextNode != null) {
                minHeap.offer(nextNode);
            }
        }
        return dummy.next;
    }
}
