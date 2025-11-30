package Practice.src.warmup;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenLinkedList {

    static class Message {

        private int timestamp;

        private Message next;

        private Message reply;

        public Message(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public Message getNext() {
            return next;
        }

        public Message getReply() {
            return reply;
        }
    }

    public static void main(String[] args) {

        Message head = new Message(5);
        head.reply = new Message(7);
        head.reply.reply = new Message(8);
        head.reply.reply.reply = new Message(30);

        head.next = new Message(10);
        head.next.reply = new Message(20);

        head.next.next = new Message(19);
        head.next.next.reply = new Message(22);
        head.next.next.reply.reply = new Message(50);
        head.next.next.next = new Message(28);

        FlattenLinkedList test = new FlattenLinkedList();
        Message message = test.flatten2(head);
        while (message != null) {
            System.out.print(message.timestamp + " ");
            message = message.reply;
        }
    }

    Message flatten2(Message head) {

        PriorityQueue<Message> pq = new PriorityQueue<>(Comparator.comparingInt(Message::getTimestamp));
        Message dummy = new Message(-1);
        Message tail = dummy;
        pq.add(head);
        while (!pq.isEmpty()) {
            Message topMessage = pq.poll();
            if (topMessage.next != null) {
                pq.add(topMessage.next);
                topMessage.next = null;
            }
            if (topMessage.reply != null) {
                pq.add(topMessage.reply);
                topMessage.reply = null;
            }
            tail.reply = topMessage;
            tail = topMessage;
        }
        return dummy.reply;
    }

    Message flatten(Message head) {

        Message newHead = null;
        while (head != null) {
            Message nextHead = head.next;
            newHead = merge(newHead, head);
            head = nextHead;
        }
        return newHead;
    }

    private Message merge(Message head1, Message head2) {

        Message dummy = new Message(-1);
        Message tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.timestamp <= head2.timestamp) {
                tail.reply = head1;
                head1 = head1.reply;
            } else {
                tail.reply = head2;
                head2 = head2.reply;
            }
            tail = tail.reply;
            tail.next = null;
        }
        tail.reply = (head1 != null) ? head1 : head2;
        return dummy.reply;
    }
}
