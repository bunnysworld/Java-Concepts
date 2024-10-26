package concepts.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.offer(4);
        queue.offer(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            System.out.println(queue.poll());
            System.out.println(queue.peek());
            System.out.println(queue.element());
        }

    }
}
